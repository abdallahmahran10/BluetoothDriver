package abdallah.mahran.blt_dirver;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

// This class handle all functionality 
// related to the Bluetooth communication
public class BluetoothHandler {
	public static final int REQUEST_ENABLE_BT = 3001;
	private BluetoothAdapter mBluetoothAdapter;
	private Activity mCallerActivity;
	//
	public BluetoothHandler(Activity activity) {
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		mCallerActivity = activity;
	}
	//
	public boolean checkBluetoothAvailability() {
		return mBluetoothAdapter != null;
	}
	//
	public boolean isEnable()
	{
		return checkBluetoothAvailability() && mBluetoothAdapter.isEnabled();
	}
	//
	public void requestBluetoothEnable()
	{
		if (checkBluetoothAvailability() && !mBluetoothAdapter.isEnabled()) {
		    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		    mCallerActivity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
		}
	}
}
