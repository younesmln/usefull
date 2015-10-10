
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class MainActivityFragment extends Fragment {
    private Button disable, enable;
    private TextView state;
    private BluetoothAdapter bluetoothAdapter;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        enable = (Button) view.findViewById(R.id.enable_button);
        disable = (Button) view.findViewById(R.id.disable_button);
        state = (TextView) view.findViewById(R.id.state_text);
        bluetoothAdapter = getAdapter();
        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothAdapter.isEnabled())
                {
                    bluetoothAdapter.enable();
                    state.setText("ON");
                    search();
                    showText(String.valueOf(bluetoothAdapter.isEnabled()));
                }
            }
        });

        disable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bluetoothAdapter.isEnabled()) {
                    bluetoothAdapter.disable();
                    state.setText("OFF");
                    showText(String.valueOf(bluetoothAdapter.isEnabled()));
                }
            }
        });
        return view;
    }

    public BluetoothAdapter getAdapter() {
        BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
        if (bluetooth == null) {
            Toast.makeText(getActivity(),
                    "there is no bluetooth is your phone :) ", Toast.LENGTH_SHORT).show();
            disable.setEnabled(false);
            enable.setEnabled(false);
            state.setText("you phone doesn't support bluetooth");
            return bluetooth;
        }else{
            return bluetooth;
        }
    }


    public void search()
    {
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        if (pairedDevices.size() > 0)
        {
            for (BluetoothDevice device : pairedDevices) state.append( device.getName() + "\n");
        }else state.append("\n hello \n "+pairedDevices.size());
    }
}
