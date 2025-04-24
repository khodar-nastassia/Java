import dto.Workplace;
import file.ObjectWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @Mock
    Data mockData;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void testAddWorkplaceMethod() {
        Scanner scanner = new Scanner("Desk\n100.0\n");

        AdminService adminService = new AdminService(scanner, mockData);

        adminService.addWorkplace();

        verify(mockData, times(1)).addWorkplace(argThat(wp ->
                wp.getType().equals("Desk") && wp.getPrice() == 100.0
        ));

        assertTrue(outContent.toString().contains("The workplace added"));
    }

    @Test
    void removeWorkplace() {
    }

    @Test
    void viewAllReservations() {
    }
}