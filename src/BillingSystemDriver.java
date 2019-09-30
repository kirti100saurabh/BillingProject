import java.text.ParseException;

import com.teleteach.billing.view.LoginView;

public class BillingSystemDriver {
	public static void main(String[] args) {
		try {
			LoginView.create();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
