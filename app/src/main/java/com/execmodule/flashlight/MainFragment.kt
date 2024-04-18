package com.execmodule.flashlight
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.LinearLayout
//import androidx.fragment.app.Fragment
//import android.content.Context
//import android.hardware.camera2.CameraAccessException
//import android.hardware.camera2.CameraManager
//class MainFragment : Fragment() {
//
//    private var isFlashlightOn = false
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        val layout = LinearLayout(container?.context)
//        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
//
//        val button = Button(container?.context)
//        button.text = "Turn On"
//        button.layoutParams = layoutParams
//        button.setOnClickListener {
//            if (isFlashlightOn) {
//                turnOff()
//                button.text = "Turn On"
//            } else {
//                turnOn()
//                button.text = "Turn Off"
//            }
//
//        }
//        layout.addView(button)
//
//        return layout
//    }
//
//    private fun turnOn() {
//        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
//        val cameraId = cameraManager.cameraIdList[0]
//        try {
//            cameraManager.setTorchMode(cameraId, true)
//            isFlashlightOn = true
//
//        } catch (_: CameraAccessException) {
//        }
//    }
//
//    private fun turnOff() {
//        val cameraManager = Context.CAMERA_SERVICE as CameraManager
//        val cameraId = cameraManager.cameraIdList[0]
//        try {
//            cameraManager.setTorchMode(cameraId, false)
//            isFlashlightOn = false
//
//        } catch (_: CameraAccessException) {
//        }
//    }
//}


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {
    private var isFlashlightOn = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = LinearLayout(container?.context)
        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        val button = Button(container?.context)
        button.text = "Toggle Flashlight"
        button.layoutParams = layoutParams
        layout.addView(button)

        button.setOnClickListener {
            toggleFlashlight()
        }

        return layout
    }

    private fun toggleFlashlight() {
        val cameraManager = activity?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]

        try {
            if (isFlashlightOn) {
                cameraManager.setTorchMode(cameraId, false)
                isFlashlightOn = false
            } else {
                if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // Request the camera permission if not granted
                    ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
                    return
                }
                cameraManager.setTorchMode(cameraId, true)
                isFlashlightOn = true
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val CAMERA_PERMISSION_REQUEST_CODE = 1001
    }
}