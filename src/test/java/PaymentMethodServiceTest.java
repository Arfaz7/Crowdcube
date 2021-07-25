import com.crowdcube.model.PaymentMethod;
import com.crowdcube.services.PaymentMethodService;
import com.crowdcube.services.impl.PaymentMethodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaymentMethodServiceTest {

    PaymentMethodService paymentMethodService;

    @BeforeEach
    void setUp() {
        paymentMethodService = new PaymentMethodServiceImpl();
    }

    @Test
    void createPaymentMethod(){
        PaymentMethod pm = paymentMethodService.create();
        assertNotNull(pm);
    }
}
