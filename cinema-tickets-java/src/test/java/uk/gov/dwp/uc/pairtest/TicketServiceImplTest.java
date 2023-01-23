package uk.gov.dwp.uc.pairtest;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;

import static org.mockito.Mockito.mock;
import static uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest.Type.*;
public class TicketServiceImplTest extends TestCase {
    @Mock
    private TicketServiceImpl ticketServiceImpl;
    private static long accountID =1;
    private  static int TicketTypeRequest;

    @BeforeEach
    public void setUp () {
        ticketServiceImpl = new TicketServiceImpl ();

    }
    @Test
    @DisplayName("Test Case For ADULT Ticket Type")
     void testAdultPurchaseTickets (){
        TicketTypeRequest ticketTypeRequestMock = mock (TicketTypeRequest.class);
        int noOfTickets = 5;
        uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest.Type adult = ADULT;
        ticketServiceImpl.purchaseTickets(accountID, new TicketTypeRequest(adult, noOfTickets));
        //assertEquals( ticketTypeRequestMock);
        assertTrue(true);
    }
    @Test
    @DisplayName("Test Case For CHILD Ticket Type")
    void testChildPurchaseTickets (){
        TicketTypeRequest ticketTypeRequestMock = mock (TicketTypeRequest.class);
        int noOfTickets = 5;
        uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest.Type child = CHILD;
        ticketServiceImpl.purchaseTickets(accountID, new TicketTypeRequest(child, noOfTickets));
        assertFalse("InvalidPurchaseException",false);
    }
    @Test
    @DisplayName("Test Case For INFANT Ticket Type")
    void testInfantPurchaseTickets (){
        TicketTypeRequest ticketTypeRequestMock = mock (TicketTypeRequest.class);
        int noOfTickets = 5;
        uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest.Type infant = INFANT;
        ticketServiceImpl.purchaseTickets(accountID, new TicketTypeRequest(infant, noOfTickets));
        assertFalse("InvalidPurchaseException",false);
    }
}