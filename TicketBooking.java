class TicketBooking implements Runnable {
    private static int availableSeats = 10;

    @Override
    public synchronized void run() {
        if (availableSeats > 0) {
            System.out.println(Thread.currentThread().getName() + " booking seat...");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            availableSeats--;
            System.out.println(Thread.currentThread().getName() + " booked a seat. Remaining seats: " + availableSeats);
        } else {
            System.out.println("No seats available for " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking();
        Thread vip1 = new Thread(ticketBooking, "VIP1");
        Thread vip2 = new Thread(ticketBooking, "VIP2");
        Thread regular1 = new Thread(ticketBooking, "Regular1");
        Thread regular2 = new Thread(ticketBooking, "Regular2");

        vip1.setPriority(Thread.MAX_PRIORITY);  
        vip2.setPriority(Thread.MAX_PRIORITY);
        regular1.setPriority(Thread.NORM_PRIORITY); 
        regular2.setPriority(Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
    }
}
