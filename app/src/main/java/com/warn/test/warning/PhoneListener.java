package com.warn.test.warning;

import android.app.Service;
import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import com.warn.test.utils.MyApplication;

public class PhoneListener extends PhoneStateListener {

    /**
     * state	当前手机的状态
     * incomingNumber	呼入的手机号码
     */

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        // TODO Auto-generated method stub
        super.onCallStateChanged(state, incomingNumber);
        Log.d("TAG", "号码:" + incomingNumber);
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE://空闲或者挂断
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK://接通
                break;
            case TelephonyManager.CALL_STATE_RINGING://来电响铃
                Log.d("TAG", "来电号码是:" + incomingNumber);
                if("15995185772".equals(incomingNumber)){
                    AudioManager audio = (AudioManager) MyApplication.getContext().getSystemService(Service.AUDIO_SERVICE);
                    audio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    audio.setStreamVolume(AudioManager.STREAM_RING, 6, AudioManager.FLAG_PLAY_SOUND);
                }
                break;
        }
    }
}
