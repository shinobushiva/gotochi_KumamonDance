package shiva.gotochi.hellolocal;

import jag.kumamoto.apps.gotochi.PrefecturesActivityBase;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class HelloLocalActivity extends PrefecturesActivityBase {

	int mCount = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Toast.makeText(this,
				"ご当地アプリは" + (isGotochiApp() ? "有効" : "無効") + "です。",
				Toast.LENGTH_SHORT).show();

		// initializeComponents();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			Log.d(this.getClass().getName(), "back button pressed");
			// moveTaskToBack(true);
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected boolean onLocationChange(Context context, Intent intent) {
		++mCount;

		if (mCount == 1) {
			Toast.makeText(this, "一度目のインテントでは終了させない", Toast.LENGTH_SHORT)
					.show();
			return true;
		} else {
			Toast.makeText(this, "二度目のインテントなので終了する", Toast.LENGTH_SHORT).show();
			return false;
		}
	}

}