package com.aserbao.aserbaosandroid.media.videoView;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.VideoView;

import com.aserbao.aserbaosandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoViewActivity extends AppCompatActivity {

    @BindView(R.id.video_view)
    VideoView mVideoView;
    @BindView(R.id.video_seek_bar)
    SeekBar mVideoSeekBar;
    private String videoUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    private String videoUrl1 = "/storage/emulated/0/DCIM/Camera/VID20180319111516.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        ButterKnife.bind(this);
//        mVideoView.setVideoURI(Uri.parse(videoUrl1));
        mVideoView.setVideoPath(videoUrl1);
        mVideoView.start();
        mVideoSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progress1 = seekBar.getProgress();
                mVideoView.seekTo(mVideoView.getDuration() * progress /100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
