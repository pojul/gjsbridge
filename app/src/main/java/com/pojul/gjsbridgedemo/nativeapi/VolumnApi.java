package com.pojul.gjsbridgedemo.nativeapi;

import android.content.Context;
import android.media.AudioManager;

/**
 * @Description: 类描述
 * @Author: ganqiubo
 * @CreateDate: 2022/8/17 23:25
 */
public class VolumnApi extends BaseApi{

    public String getVolumn(Context context){
        if(context==null){
            return "fail";
        }
        AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_MUSIC );
        int current = mAudioManager.getStreamVolume( AudioManager.STREAM_MUSIC );
        return ("volumn max: " + max + "; current" + current);
    }

}
