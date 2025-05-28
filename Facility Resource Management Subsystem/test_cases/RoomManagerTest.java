package test_cases;

import facility_resource_management.RoomManager;
import facility_resource_management.Resident;
import facility_resource_management.ResidentRegistry;
import facility_resource_management.Room;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test cases for the RoomManager and ResidentRegistry classes
 * of the Facility Resource Management Subsystem.
 * 
 * Includes tests for room allocation, release, resident registration,
 * and validation using various assertion types.
 */
public class RoomManagerTest {

    private RoomManager roomManager;
    private Resident testResident;

    /**
     * Executed before each test. Initializes RoomManager and a test resident.
     */
    @Before
    public void setUp() {
        roomManager = RoomManager.getInstance();
        testResident = new Resident("R001", "John Doe", "2025-05-20");
    }

    /**
     * Executed after each test. Releases test room allocations.
     */
    @After
    public void tearDown() {
        roomManager.releaseRoom("101");
        roomManager.releaseRoom("102");
        roomManager.releaseRoom("103");
    }

    /**
     * ✅ Test 1: Normal case – Allocate room to a new resident.
     * Uses: assertTrue
     */
    @Test
    public void testAllocateRoomToResident_Success() {
        boolean result = roomManager.allocateRoomToResident("101", testResident);
        assertTrue("Room should be successfully allocated to resident", result);
    }

    /**
     * ✅ Test 2: Normal case – Release room and check its status.
     * Uses: assertEquals
     */
    @Test
    public void testReleaseRoom_Success() {
        Resident resident = new Resident("R002", "Alice Smith", "2025-05-21");
        roomManager.allocateRoomToResident("102", resident);
        roomManager.releaseRoom("102");

        String status = null;
        for (Room r : roomManager.getAvailableRooms()) {
            if (r.getRoomNumber().equals("102")) {
                status = r.getState().getStatus();
            }
        }

        assertEquals("Room status should be 'Available' after release", "Available", status);
    }

    /**
     * ✅ Test 3: Edge case – Try to allocate an already-occupied room.
     * Uses: assertFalse
     */
    @Test
    public void testAllocateRoomToOccupiedRoom_Fails() {
        Resident firstResident = new Resident("R003", "Bob Parker", "2025-05-22");
        Resident secondResident = new Resident("R004", "Lily Grace", "2025-05-22");

        roomManager.allocateRoomToResident("103", firstResident);
        boolean result = roomManager.allocateRoomToResident("103", secondResident);

        assertFalse("Room should not be allocated again if already occupied", result);
    }

    /**
     * ✅ Test 4: Normal case – Register and retrieve a resident.
     * Uses: assertNotNull
     */
    @Test
    public void testGetResidentFromRegistry_Success() {
        ResidentRegistry registry = ResidentRegistry.getInstance();

        Resident resident = new Resident("R005", "Emma Watson", "2025-05-23");
        registry.registerResident(resident);

        Resident retrieved = registry.getResidentById("R005");

        assertNotNull("Resident should be retrievable from registry after registration", retrieved);
    }

    /**
     * ✅ Test 5: Error case – Attempt to retrieve non-existent resident.
     * Uses: assertNull
     */
    @Test
    public void testGetResidentByInvalidId_ReturnsNull() {
        ResidentRegistry registry = ResidentRegistry.getInstance();
        Resident result = registry.getResidentById("INVALID_ID");

        assertNull("Resident with invalid ID should return null", result);
    }

    /**
     * ✅ Test 6: Ensure different resident instances are not the same.
     * Uses: assertNotSame
     */
    @Test
    public void testResidentInstancesAreNotSame() {
        Resident resident1 = new Resident("R006", "Michael Scott", "2025-05-24");
        Resident resident2 = new Resident("R007", "Dwight Schrute", "2025-05-24");

        assertNotSame("Different Resident objects should not reference the same instance", resident1, resident2);
    }
}
