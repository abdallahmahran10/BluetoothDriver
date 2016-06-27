package abdallah.mahran.blt_dirver;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private Button sendButton;
	private Button connectButton;
	// blt related fields
	private boolean blthAvailable;
	BluetoothHandler mBluetoothHandler;
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main);
		super.onPostCreate(savedInstanceState);
		connectButton=(Button) findViewById(R.id.buttonConnect);
		connectButton.setEnabled(false);
		sendButton=(Button) findViewById(R.id.buttonSend);
		sendButton.setOnClickListener(this);
		mBluetoothHandler = new BluetoothHandler(this);
		blthAvailable = mBluetoothHandler.checkBluetoothAvailability();
		if(!blthAvailable)
			mBluetoothHandler.requestBluetoothEnable();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(BluetoothHandler.REQUEST_ENABLE_BT == requestCode && resultCode == RESULT_OK)
		{
			// TODO: chech result
		}
		super.onActivityResult(requestCode, resultCode, data);
	}


	@Override
	public void onClick(View v) {
		// on user press send
		
	}
}
