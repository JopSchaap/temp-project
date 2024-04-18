package com.execmodule.flashlight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
class MainFragment : Fragment() {

    private var isFlashlightOn = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = LinearLayout(container?.context)
        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        val button = Button(container?.context)
        button.text = "Turn On"
        button.layoutParams = layoutParams
        button.setOnClickListener {
            if (isFlashlightOn) {
                turnOff()
                button.text = "Turn On"
            } else {
                turnOn()
                button.text = "Turn Off"
            }
        }
        layout.addView(button)

        return layout
    }

    private fun turnOn() {
        val cameraManager = activity?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]
        try {
            cameraManager.setTorchMode(cameraId, true)
            isFlashlightOn = true

        } catch (_: CameraAccessException) {
        }
    }

    private fun turnOff() {
        val cameraManager = activity?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]
        try {
            cameraManager.setTorchMode(cameraId, false)
            isFlashlightOn = false

        } catch (_: CameraAccessException) {
        }
    }
}