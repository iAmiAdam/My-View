package info.adamjsmith.myview;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class CameraFragment extends Fragment {
	Camera camera;
	CameraPreview mCameraPreview;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		View v = inflater.inflate(R.layout.camerafragment, container, false);
		
		camera = getCameraInstance();
		mCameraPreview = new CameraPreview(getActivity().getBaseContext(), camera);
		FrameLayout preview = (FrameLayout) v.findViewById(R.id.cameraPreview);
		preview.addView(mCameraPreview);
		
		return v;
	}
	
	private Camera getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open();
		} catch (Exception e) {
			
		}
		return c;
	}
}
