/*
 * PanoramaGL library
 * Version 0.2 beta
 * Copyright (c) 2010 Javier Baez <javbaezga@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.hellopanoramagl;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.panoramagl.PLCamera;
import com.panoramagl.PLConstants;
import com.panoramagl.PLCubicPanorama;
import com.panoramagl.PLCylindricalPanorama;
import com.panoramagl.PLICamera;
import com.panoramagl.PLISceneElement;
import com.panoramagl.PLIView;
import com.panoramagl.PLImage;
import com.panoramagl.PLPanoramaBase;
import com.panoramagl.PLSpherical2Panorama;
import com.panoramagl.PLSphericalPanorama;
import com.panoramagl.PLView;
import com.panoramagl.PLViewListener;
import com.panoramagl.computation.PLVector3;
import com.panoramagl.enumerations.PLCameraAnimationType;
import com.panoramagl.enumerations.PLCubeFaceOrientation;
import com.panoramagl.hotspots.PLHotspot;
import com.panoramagl.hotspots.PLIHotspot;
import com.panoramagl.ios.UITouch;
import com.panoramagl.ios.structs.CGPoint;
import com.panoramagl.ios.structs.UIAcceleration;
import com.panoramagl.loaders.PLILoader;
import com.panoramagl.loaders.PLJSONLoader;
import com.panoramagl.structs.PLPosition;
import com.panoramagl.transitions.PLITransition;
import com.panoramagl.transitions.PLTransitionBlend;
import com.panoramagl.utils.PLUtils;

public class MainActivity extends PLView implements OnClickListener {
	/** member variables */
	public static final String TAG = "MainActivity";
	private Spinner mPanoramaTypeSpinner;
	private ZoomControls mZoomControls;
	private Button mAddHotSpot;
	private Button mDeleteHotSpot;
	private Button mOK;
	private Button mCancel;
	public static float matv = 0.0f;
	public static float math = 0.0f;
	private PLPanoramaBase panorama = null;
	private int id = 100;
	private List<PLHotspot> hotSpotList = new ArrayList<PLHotspot>();
	private PLHotspot preHotSpot = null;
	private Boolean addHotSpot = false;
	private Boolean delHotSpot = false;

	/** init methods */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setListener(new PLViewListener() {
			@Override
			public void onTouchesEnded(PLIView view, List<UITouch> touches,
					MotionEvent event) {
				// TODO Auto-generated method stub
				super.onTouchesEnded(view, touches, event);
				// loadPanorama(2);
				/*
				 * PLVector3 plVector3 =
				 * panorama.getCollisionData().hitPoint[0]; float x =
				 * plVector3.x; float y = plVector3.y; float z = plVector3.z;
				 * //float[] py = convertPositionToPitchAndYaw(y,z,x); float[]
				 * py = convertPositionToPitchAndYaw(x,y,z);
				 * Log.d("MainActivity", "(x,y,z)"+ x+ "," + y +","+ z +
				 * " py = (" + py[0] +","+py[1]+")"); PLHotspot hotspot1 = new
				 * PLHotspot(++id, new
				 * PLImage(PLUtils.getBitmap(getApplicationContext(),
				 * R.raw.hotspot), false), py[0], py[1], 0.05f, 0.05f);
				 * panorama.addHotspot(hotspot1);
				 */
				// Reset view
				// reset();
				// Load panorama
				// startTransition(new PLTransitionBlend(2.0f), panorama); //or
				// use this.setPanorama(panorama);

				/*
				 * panorama = (PLPanoramaBase) getPanorama(); PLVector3
				 * plVector3 = panorama.getCollisionData().hitPoint[0]; float x
				 * = plVector3.x; float y = plVector3.y; float z = plVector3.z;
				 * Log.d("MainActivity", "(x,y,z)"+ x+ "," + y +","+ z); float[]
				 * pr = convertPositionToPitchAndYaw(y,z,x); panorama = new
				 * PLSphericalPanorama();
				 * ((PLSphericalPanorama)panorama).setImage(new
				 * PLImage(PLUtils.getBitmap(getApplicationContext(),
				 * R.raw.quito1_s), false)); panorama.getCamera().lookAt(0.0f,
				 * 0.0f);//璁剧疆鍨傜洿锛屾按骞� //Add a hotspot panorama.addHotspot(new
				 * PLHotspot(++id,new
				 * PLImage(PLUtils.getBitmap(MainActivity.this, R.raw.hotspot),
				 * false), pr[0], pr[1], 0.05f, 0.05f)); //Reset view reset();
				 * //Load panorama startTransition(new PLTransitionBlend(2.0f),
				 * panorama); //or use this.setPanorama(panorama);
				 */
				/*
				 * View v= null; v.getX(); v.getScrollX(); v.getTranslationX();
				 * v.getScrollX();
				 */
			}

			@Override
			public void onDidEndTouching(PLIView view, List<UITouch> touches,
					MotionEvent event) {
				// TODO Auto-generated method stub
				super.onDidEndTouching(view, touches, event);

			}

			@Override
			public void onDidOverElement(PLIView view, PLISceneElement element,
					CGPoint screenPoint, PLPosition scene3dPoint) {
				// TODO Auto-generated method stub
				super.onDidOverElement(view, element, screenPoint, scene3dPoint);
			}

			@Override
			public void onDidClickElement(PLIView view,
					PLISceneElement element, CGPoint screenPoint,
					PLPosition scene3dPoint) {
				// TODO Auto-generated method stub
				super.onDidClickElement(view, element, screenPoint,
						scene3dPoint);
			}

			@Override
			public void onDidOutElement(PLIView view, PLISceneElement element,
					CGPoint screenPoint, PLPosition scene3dPoint) {
				// TODO Auto-generated method stub
				super.onDidOutElement(view, element, screenPoint, scene3dPoint);
			}

			@Override
			public void onDidOverHotspot(PLIView view, PLIHotspot hotspot,
					CGPoint screenPoint, PLPosition scene3dPoint) {
				// TODO Auto-generated method stub
				super.onDidOverHotspot(view, hotspot, screenPoint, scene3dPoint);
			}

			@Override
			public void onDidOutHotspot(PLIView view, PLIHotspot hotspot,
					CGPoint screenPoint, PLPosition scene3dPoint) {
				// TODO Auto-generated method stub
				super.onDidOutHotspot(view, hotspot, screenPoint, scene3dPoint);
			}

			@Override
			public void onDidClickHotspot(PLIView view, PLIHotspot hotspot,
					CGPoint screenPoint, PLPosition scene3DPoint) {
				Toast.makeText(
						view.getActivity().getApplicationContext(),
						String.format("You select the hotspot with ID %d",
								hotspot.getIdentifier()), Toast.LENGTH_SHORT)
						.show();

				PLCamera camera = (PLCamera) (getPanorama().getCamera());
				if (camera.isActionMode()) {
					panorama.removeHotspot(hotspot);
				}
			}

			@Override
			public void onDidBeginLoader(PLIView view, PLILoader loader) {
				setControlsEnabled(false);
			}

			@Override
			public void onDidCompleteLoader(PLIView view, PLILoader loader) {
				setControlsEnabled(true);
			}

			@Override
			public void onDidErrorLoader(PLIView view, PLILoader loader,
					String error) {
				setControlsEnabled(true);
			}

			@Override
			public void onDidBeginTransition(PLIView view,
					PLITransition transition) {
				setControlsEnabled(false);
			}

			@Override
			public void onDidStopTransition(PLIView view,
					PLITransition transition, int progressPercentage) {
				setControlsEnabled(true);
			}

			@Override
			public void onDidEndTransition(PLIView view,
					PLITransition transition) {
				setControlsEnabled(true);
			}

			@Override
			public void onTouchesBegan(PLIView view, List<UITouch> touches,
					MotionEvent event) {
				// TODO Auto-generated method stub
				super.onTouchesBegan(view, touches, event);
			}

			@Override
			public void onTouchesMoved(PLIView view, List<UITouch> touches,
					MotionEvent event) {
				// TODO Auto-generated method stub
				super.onTouchesMoved(view, touches, event);
				PLCamera camera = (PLCamera) (getPanorama().getCamera());
				PLVector3 plVector3 = panorama.getCollisionData().hitPoint[0];
				float x = plVector3.x;
				float y = plVector3.y;
				float z = plVector3.z;
				float[] py = convertPositionToPitchAndYaw(x, y, z);
				Log.d("MainActivity", "(x,y,z)" + x + "," + y + "," + z
						+ " py = (" + py[0] + "," + py[1] + ")");
				if (!camera.isActionMode()) {
					return;
				}

				if (addHotSpot) {
					
					// float[] py = convertPositionToPitchAndYaw(y,z,x);
					
					PLHotspot hotspot1 = new PLHotspot(++id, new PLImage(
							PLUtils.getBitmap(getApplicationContext(),
									R.raw.hotspot), false), py[0], py[1],
							0.05f, 0.05f);
					panorama.addHotspot(hotspot1);
					if (preHotSpot != null) {
						panorama.removeHotspot(preHotSpot);
					}
					preHotSpot = hotspot1;
				}
			}

			@Override
			public boolean onShouldBeginTouching(PLIView view,
					List<UITouch> touches, MotionEvent event) {
				// TODO Auto-generated method stub
				return super.onShouldBeginTouching(view, touches, event);
			}

			@Override
			public void onDidBeginTouching(PLIView view, List<UITouch> touches,
					MotionEvent event) {
				// TODO Auto-generated method stub
				super.onDidBeginTouching(view, touches, event);
			}

			@Override
			public boolean onShouldMoveTouching(PLIView view,
					List<UITouch> touches, MotionEvent event) {
				// TODO Auto-generated method stub
				return super.onShouldMoveTouching(view, touches, event);
			}

			@Override
			public void onDidMoveTouching(PLIView view, List<UITouch> touches,
					MotionEvent event) {
				// TODO Auto-generated method stub
				super.onDidMoveTouching(view, touches, event);
			}

			@Override
			public boolean onShouldEndTouching(PLIView view,
					List<UITouch> touches, MotionEvent event) {
				// TODO Auto-generated method stub
				return super.onShouldEndTouching(view, touches, event);
			}

			@Override
			public boolean onShouldAccelerate(PLIView view,
					UIAcceleration acceleration, SensorEvent event) {
				// TODO Auto-generated method stub
				return super.onShouldAccelerate(view, acceleration, event);
			}

			@Override
			public void onDidAccelerate(PLIView view,
					UIAcceleration acceleration, SensorEvent event) {
				// TODO Auto-generated method stub
				super.onDidAccelerate(view, acceleration, event);
			}

			@Override
			public boolean onShouldBeginInertia(PLIView view,
					CGPoint startPoint, CGPoint endPoint) {
				// TODO Auto-generated method stub
				return super.onShouldBeginInertia(view, startPoint, endPoint);
			}

			@Override
			public void onDidBeginInertia(PLIView view, CGPoint startPoint,
					CGPoint endPoint) {
				// TODO Auto-generated method stub
				super.onDidBeginInertia(view, startPoint, endPoint);
			}

			@Override
			public boolean onShouldRunInertia(PLIView view, CGPoint startPoint,
					CGPoint endPoint) {
				// TODO Auto-generated method stub
				return super.onShouldRunInertia(view, startPoint, endPoint);
			}

			@Override
			public void onDidRunInertia(PLIView view, CGPoint startPoint,
					CGPoint endPoint) {
				// TODO Auto-generated method stub
				super.onDidRunInertia(view, startPoint, endPoint);
			}

			@Override
			public void onDidEndInertia(PLIView view, CGPoint startPoint,
					CGPoint endPoint) {
				// TODO Auto-generated method stub
				super.onDidEndInertia(view, startPoint, endPoint);
			}

			@Override
			public boolean onShouldBeingScrolling(PLIView view,
					CGPoint startPoint, CGPoint endPoint) {
				// TODO Auto-generated method stub
				return super.onShouldBeingScrolling(view, startPoint, endPoint);
			}

			@Override
			public void onDidBeginScrolling(PLIView view, CGPoint startPoint,
					CGPoint endPoint) {
				// TODO Auto-generated method stub
				super.onDidBeginScrolling(view, startPoint, endPoint);
			}

			@Override
			public void onDidEndScrolling(PLIView view, CGPoint startPoint,
					CGPoint endPoint) {
				// TODO Auto-generated method stub
				super.onDidEndScrolling(view, startPoint, endPoint);
			}

			@Override
			public boolean onShouldBeginZooming(PLIView view) {
				// TODO Auto-generated method stub
				return super.onShouldBeginZooming(view);
			}

			@Override
			public void onDidBeginZooming(PLIView view, CGPoint startPoint,
					CGPoint endPoint) {
				// TODO Auto-generated method stub
				super.onDidBeginZooming(view, startPoint, endPoint);
			}

			@Override
			public boolean onShouldRunZooming(PLIView view, float distance,
					boolean isZoomIn, boolean isZoomOut) {
				// TODO Auto-generated method stub
				return super.onShouldRunZooming(view, distance, isZoomIn,
						isZoomOut);
			}

			@Override
			public void onDidRunZooming(PLIView view, float distance,
					boolean isZoomIn, boolean isZoomOut) {
				// TODO Auto-generated method stub
				super.onDidRunZooming(view, distance, isZoomIn, isZoomOut);
			}

			@Override
			public void onDidEndZooming(PLIView view) {
				// TODO Auto-generated method stub
				super.onDidEndZooming(view);
			}

			@Override
			public boolean onShouldReset(PLIView view) {
				// TODO Auto-generated method stub
				return super.onShouldReset(view);
			}

			@Override
			public void onDidReset(PLIView view) {
				// TODO Auto-generated method stub
				super.onDidReset(view);
			}

			@Override
			public void onDidBeginCameraAnimation(PLIView view, Object sender,
					PLICamera camera, PLCameraAnimationType type) {
				// TODO Auto-generated method stub
				super.onDidBeginCameraAnimation(view, sender, camera, type);
				Log.d(TAG,
						" onDidBeginCameraAnimation patch = "
								+ camera.getPitch());
				Log.d(TAG,
						" onDidBeginCameraAnimation yaw = " + camera.getYaw());
			}

			@Override
			public void onDidEndCameraAnimation(PLIView view, Object sender,
					PLICamera camera, PLCameraAnimationType type) {
				// TODO Auto-generated method stub
				super.onDidEndCameraAnimation(view, sender, camera, type);
				Log.d(TAG,
						" onDidEndCameraAnimation patch = " + camera.getPitch());
				Log.d(TAG, " onDidEndCameraAnimation yaw = " + camera.getYaw());
			}

			@Override
			public void onDidResetCamera(PLIView view, Object sender,
					PLICamera camera) {
				// TODO Auto-generated method stub
				super.onDidResetCamera(view, sender, camera);
			}

			@Override
			public void onDidLookAtCamera(PLIView view, Object sender,
					PLICamera camera, float pitch, float yaw, boolean animated) {
				// TODO Auto-generated method stub
				super.onDidLookAtCamera(view, sender, camera, pitch, yaw,
						animated);
				Log.d(TAG, " onDidLookAtCamera patch = " + camera.getPitch());
				Log.d(TAG, " onDidLookAtCamera yaw = " + camera.getYaw());
			}

			@Override
			public void onDidRotateCamera(PLIView view, Object sender,
					PLICamera camera, float pitch, float yaw, float roll) {
				// TODO Auto-generated method stub
				super.onDidRotateCamera(view, sender, camera, pitch, yaw, roll);
				Log.d(TAG, " onDidRotateCamera patch = " + camera.getPitch());
				Log.d(TAG, " onDidRotateCamera yaw = " + camera.getYaw());
			}

			@Override
			public void onDidRotateCameraDelta(PLIView view, Object sender,
					PLICamera camera, float pitchDelta, float yawDelta) {
				// TODO Auto-generated method stub
				Log.d(TAG, " onDidRotateCameraDelta patchDelta = " + pitchDelta);
				Log.d(TAG, " onDidRotateCameraDelta yawDelta = " + yawDelta);
				PLIHotspot hotspot = panorama.getHotspot(0);
				hotspot.setAth(hotspot.getYaw() - yawDelta);
				hotspot.setAtv(hotspot.getPitch() - pitchDelta);
				// Reset view
				// reset();
				// Load panorama
				// startTransition(new PLTransitionBlend(0.1f), panorama); //or
				// use this.setPanorama(panorama);
			}

			@Override
			public void onDidFovCamera(PLIView view, Object sender,
					PLICamera camera, float fov, boolean animated) {
				// TODO Auto-generated method stub
				super.onDidFovCamera(view, sender, camera, fov, animated);
			}

			@Override
			public void onDidProcessTransition(PLIView view,
					PLITransition transition, int progressPercentage) {
				// TODO Auto-generated method stub
				super.onDidProcessTransition(view, transition,
						progressPercentage);
			}

			@Override
			public void onDidStopLoader(PLIView view, PLILoader loader) {
				// TODO Auto-generated method stub
				super.onDidStopLoader(view, loader);
			}

		});
	}

	/**
	 * This event is fired when root content view is created
	 * 
	 * @param contentView
	 *            current root content view
	 * @return root content view that Activity will use
	 */
	@Override
	protected View onContentViewCreated(View contentView) {
		// Load layout
		ViewGroup mainView = (ViewGroup) this.getLayoutInflater().inflate(
				R.layout.activity_main, null);
		// Add 360 view
		mainView.addView(contentView, 0);
		// Spinner control
		mPanoramaTypeSpinner = (Spinner) mainView
				.findViewById(R.id.spinner_panorama_type);
		ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
				R.array.panorama_types, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mPanoramaTypeSpinner.setAdapter(adapter);
		mPanoramaTypeSpinner
				.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parentView,
							View selectedItemView, int position, long id) {
						// loadPanoramaFromJSON(position);
						loadPanorama(position);
					}

					@Override
					public void onNothingSelected(AdapterView<?> parentView) {
					}
				});
		// Zoom controls
		mZoomControls = (ZoomControls) mainView
				.findViewById(R.id.zoom_controls);
		mZoomControls.setOnZoomInClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				PLICamera camera = getCamera();
				if (camera != null)
					camera.zoomIn(true);
			}
		});
		mZoomControls.setOnZoomOutClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				PLICamera camera = getCamera();
				if (camera != null)
					camera.zoomOut(true);
			}
		});

		mAddHotSpot = (Button) mainView.findViewById(R.id.add_hot_spot);
		mDeleteHotSpot = (Button) mainView.findViewById(R.id.del_hot_spot);
		mOK = (Button) mainView.findViewById(R.id.ok);
		mCancel = (Button) mainView.findViewById(R.id.cancel);

		mAddHotSpot.setOnClickListener(this);
		mDeleteHotSpot.setOnClickListener(this);
		mOK.setOnClickListener(this);
		mCancel.setOnClickListener(this);
		// Return root content view
		return super.onContentViewCreated(mainView);
	}

	/** utility methods */

	private void setControlsEnabled(final boolean isEnabled) {
		this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				if (mPanoramaTypeSpinner != null) {
					mPanoramaTypeSpinner.setEnabled(isEnabled);
					mZoomControls.setIsZoomInEnabled(isEnabled);
					mZoomControls.setIsZoomOutEnabled(isEnabled);
				}
			}
		});
	}

	/** load methods */

	/**
	 * Load panorama image manually
	 * 
	 * @param index
	 *            Spinner position where 0 = cubic, 1 = spherical2, 2 =
	 *            spherical, 3 = cylindrical
	 */
	@SuppressWarnings("unused")
	private void loadPanorama(int index) {
		try {
			Context context = this.getApplicationContext();
			// PLIPanorama panorama = null;
			// /panorama = null;
			// PLVector3[] data = panorama.getCollisionData().hitPoint;
			// Lock panoramic view
			this.setLocked(true);
			// Create panorama
			switch (index) {
			// Cubic panorama (supports up 1024x1024 image per face)
			case 0:
				PLCubicPanorama cubicPanorama = new PLCubicPanorama();
				cubicPanorama.setImage(
						new PLImage(PLUtils.getBitmap(context, R.raw.quito1_f),
								false),
						PLCubeFaceOrientation.PLCubeFaceOrientationFront);
				cubicPanorama.setImage(
						new PLImage(PLUtils.getBitmap(context, R.raw.quito1_b),
								false),
						PLCubeFaceOrientation.PLCubeFaceOrientationBack);
				cubicPanorama.setImage(
						new PLImage(PLUtils.getBitmap(context, R.raw.quito1_l),
								false),
						PLCubeFaceOrientation.PLCubeFaceOrientationLeft);
				cubicPanorama.setImage(
						new PLImage(PLUtils.getBitmap(context, R.raw.quito1_r),
								false),
						PLCubeFaceOrientation.PLCubeFaceOrientationRight);
				cubicPanorama.setImage(
						new PLImage(PLUtils.getBitmap(context, R.raw.quito1_u),
								false),
						PLCubeFaceOrientation.PLCubeFaceOrientationUp);
				cubicPanorama.setImage(
						new PLImage(PLUtils.getBitmap(context, R.raw.quito1_d),
								false),
						PLCubeFaceOrientation.PLCubeFaceOrientationDown);
				panorama = cubicPanorama;
				break;
			// Spherical2 panorama (supports up 2048x1024 image)
			case 1:
				panorama = new PLSpherical2Panorama();
				((PLSpherical2Panorama) panorama).setImage(new PLImage(PLUtils
						.getBitmap(context, R.raw.quito1_s2), false));
				break;
			// Spherical panorama (supports up 1024x512 image)
			case 2:
				panorama = new PLSphericalPanorama();
				((PLSphericalPanorama) panorama).setImage(new PLImage(PLUtils
						.getBitmap(context, R.raw.quito1_s), false));
				break;
			// Cylindrical panorama (supports up 1024x1024 image)
			case 3:
				PLCylindricalPanorama cylindricalPanorama = new PLCylindricalPanorama();
				cylindricalPanorama.setHeight(3.0f);
				cylindricalPanorama.getCamera().setPitchRange(0.0f, 0.0f);
				cylindricalPanorama.setImage(new PLImage(PLUtils.getBitmap(
						context, R.raw.quito1_s), false));
				panorama = cylindricalPanorama;
				break;
			default:
				break;
			}
			if (panorama != null) {
				// Set camera rotation
				panorama.getCamera().lookAt(0.0f, 0.0f);// 璁剧疆鍨傜洿锛屾按骞�
				Log.d(this.getClass().getSimpleName(), "camera(x,y,z)"
						+ panorama.getCamera().getX() + ","
						+ panorama.getCamera().getY() + ","
						+ panorama.getCamera().getZ());
				panorama.getCamera().getX();
				panorama.getCamera().getY();
				panorama.getCamera().getZ();
				// Add a hotspot
				PLHotspot hotspot1 = new PLHotspot(++id, new PLImage(
						PLUtils.getBitmap(context, R.raw.hotspot), false),
						0.0f, 0.0f, 0.05f, 0.05f);
				panorama.addHotspot(hotspot1);
				// PLHotspot hotspot2 = new PLHotspot(++id, new
				// PLImage(PLUtils.getBitmap(context, R.raw.hotspot), false),
				// 0.0f, 0.0f + id*10, 0.05f, 0.05f);
				// panorama.addHotspot(hotspot2);
				// PLHotspot hotspot3 = new PLHotspot(++id, new
				// PLImage(PLUtils.getBitmap(context, R.raw.hotspot), false),
				// 0.0f, 0.0f + id*10, 0.05f, 0.05f);
				// panorama.addHotspot(hotspot3);
				// PLHotspot hotspot4 = new PLHotspot(++id, new
				// PLImage(PLUtils.getBitmap(context, R.raw.hotspot), false),
				// 0.0f, 0.0f + id*10, 0.05f, 0.05f);
				// panorama.addHotspot(hotspot4);
				// Reset view
				this.reset();
				// Load panorama
				this.startTransition(new PLTransitionBlend(2.0f), panorama); // or
																				// use
																				// this.setPanorama(panorama);
			}
			// Unlock panoramic view
			this.setLocked(false);
		} catch (Throwable e) {
			Toast.makeText(this.getApplicationContext(), "Error: " + e,
					Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * Load panorama image using JSON protocol
	 * 
	 * @param index
	 *            Spinner position where 0 = cubic, 1 = spherical2, 2 =
	 *            spherical, 3 = cylindrical
	 */
	private void loadPanoramaFromJSON(int index) {
		try {
			PLILoader loader = null;
			switch (index) {
			case 0:
				loader = new PLJSONLoader("res://raw/json_cubic");
				break;
			case 1:
				loader = new PLJSONLoader("res://raw/json_spherical2");
				break;
			case 2:
				loader = new PLJSONLoader("res://raw/json_spherical");
				break;
			case 3:
				loader = new PLJSONLoader("res://raw/json_cylindrical");
				break;
			default:
				break;
			}
			if (loader != null)
				this.load(loader, true, new PLTransitionBlend(2.0f));
		} catch (Throwable e) {
			Toast.makeText(this.getApplicationContext(), "Error: " + e,
					Toast.LENGTH_SHORT).show();
		}
	}

	/** add by myself */
	public static float[] convertPositionToPitchAndYaw(float x, float y, float z) {
		double r = Math.sqrt(x * x + y * y + z * z);

		double pr = Math.acos(y / r);
		float yr = 0;
		if ((x > 0 && z > 0) || (z > 0 && x < 0)) {
			// 第一，第四象限
			Log.d(TAG, "xiang xian 1/4");
			yr = (float) Math.atan(x / z);

		} else if ((z < 0 && x > 0)) {
			Log.d(TAG, "xiang xian 2");
			yr = (float) (Math.atan(x / z)) + PLConstants.kPI;
			// yr = (float) (Math.atan(x/z) );
		} else if (x < 0 && z < 0) {
			Log.d(TAG, "xiang xian 3");
			yr = (float) (Math.atan(x / z)) - PLConstants.kPI;
			// yr = (float) (Math.atan(x/z));
		} else if (z == 0 && x > 0) {
			yr = -PLConstants.kPI / 2;
		} else if (z == 0 && x < 0) {
			yr = PLConstants.kPI / 2;
		}

		double pitch = 90 - pr / PLConstants.kToRadians;
		double yaw = -yr / PLConstants.kToRadians;

		float[] py = new float[] { (float) pitch, (float) yaw };
		Log.d("PLHotspot", " x,y,z = " + x + "," + y + "," + z);
		Log.d("PLHotspot", " yr = " + yr);
		Log.d("PLHotspot", " pitch = " + py[0] + " yaw = " + py[1]);
		Log.d("PLHotspot", " r = " + r);

		return py;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.add_hot_spot: {
			// ((PLCamera)(this.getPanorama().getCamera())).setActionMode(true);
			PLCamera camera = (PLCamera) (getPanorama().getCamera());
			camera.setActionMode(true);
			addHotSpot = true;
			delHotSpot = false;
			break;
		}
		case R.id.del_hot_spot: {
			PLCamera camera = (PLCamera) (getPanorama().getCamera());
			camera.setActionMode(true);
			addHotSpot = false;
			delHotSpot = true;
			break;
		}
		case R.id.ok: {
			PLCamera camera = (PLCamera) (getPanorama().getCamera());
			camera.setActionMode(false);
			preHotSpot = null;
			addHotSpot = false;
			delHotSpot = false;
			break;
		}

		}

	}
}