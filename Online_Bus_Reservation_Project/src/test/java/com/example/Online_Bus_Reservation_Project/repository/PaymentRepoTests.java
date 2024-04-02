package com.example.Online_Bus_Reservation_Project.repository;


    import com.example.Online_Bus_Reservation_Project.entity.Payment;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

    import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class PaymentRepoTests {
    @Autowired
    private PaymentRepo paymentRepo;
    private Payment payment;


    @BeforeEach
    public void setUp(){
        payment= Payment.builder()
                .cardNumber("123456")
                .nameOnCard("chitra")
                .price(34023L).build();
    }

    @DisplayName("Test whether the payment get saved in DB")
    @Test
    public void givenPayment_whenSave_thenReturnSavedPayment() {
        Payment savedPayment = paymentRepo.save(payment);
        assertThat(savedPayment).isNotNull();
        assertThat(savedPayment.getId()).isGreaterThan(0);


    }
}
