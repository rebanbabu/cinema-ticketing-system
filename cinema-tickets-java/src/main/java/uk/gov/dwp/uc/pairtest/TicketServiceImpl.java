package uk.gov.dwp.uc.pairtest;

import thirdparty.paymentgateway.TicketPaymentService;
import thirdparty.seatbooking.SeatReservationService;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

import java.util.stream.Stream;

import static uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest.*;
import static uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest.Type.*;

public class TicketServiceImpl implements TicketService {
      private static  int infantTicket;
      private static int childTicket;
      private static int adultTicket;
      private static int seatToBeAllocated;
      private static int totalAmountToPay;
      private  final int adultAmount =20;
      private  final int  childAmount =10;
     private  static int  totalTickets;
     private  final SeatReservationService seatReservationService =null;
     private  final TicketPaymentService ticketPaymentService =null;

    @Override
    public void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {
             if (accountId > 0) {
                 if(ticketTypeRequests.length > 0) { for(TicketTypeRequest i : ticketTypeRequests) {
                         if (ADULT == i.getTicketType()) {
                             adultTicket = i.getNoOfTickets();
                         } else if (CHILD == i.getTicketType()) {
                             childTicket = i.getNoOfTickets();
                         } else {
                             infantTicket = i.getNoOfTickets();
                         }
                     }
                     if (adultTicket > 0){
                          totalTickets = adultTicket + childTicket + infantTicket;
                          if (totalTickets > 0 && totalTickets <=20){
                              seatToBeAllocated = adultTicket + childTicket;
                              totalAmountToPay = (adultTicket * adultAmount) + (childTicket * childAmount);
                              seatReservationService.reserveSeat(accountId, seatToBeAllocated);
                              ticketPaymentService.makePayment(accountId,totalAmountToPay);
                          }
                          else{
                              throw new InvalidPurchaseException();
                          }
                     }
                     else{
                         throw new InvalidPurchaseException();
                     }
                 }
             }
    }
}
