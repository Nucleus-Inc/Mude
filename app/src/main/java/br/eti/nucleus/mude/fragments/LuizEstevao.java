package br.eti.nucleus.mude.fragments;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import br.eti.nucleus.mude.R;
import br.eti.nucleus.mude.activitys.MainActivity;

public class LuizEstevao extends android.support.v4.app.Fragment {

    private static final String API_KEY = "AIzaSyCz2MkNyp2qYaGEsgcGTd2B2R0sjqbu8EI";
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;
    private static String VIDEO_ID = "pE22tsXVFlc";
    public static Boolean fullscreen = false;
    public static Boolean flag = false;
    public static YouTubePlayer player;
    private int display_mode;
    private static final String TIME_PAUSED = "timePaused";

    @Override
    public void onAttach(Context context) {
        MainActivity.myToolbar.setTitle("Operações do MPF");
        MainActivity.actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        super.onAttach(context);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(TIME_PAUSED, player.getCurrentTimeMillis());
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        MainActivity.isOpenDrawer = false;

        View rootView = inflater.inflate(R.layout.fragment_luiz_estevao,container,false);

        youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout,youTubePlayerSupportFragment).commit();

        youTubePlayerSupportFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean wasRestored) {
                if (!wasRestored) {
                    player = youTubePlayer;

                    youTubePlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                        @Override
                        public void onFullscreen(boolean fullsize) {
                            fullscreen = fullsize;
                            if (fullsize) {
                                flag = true;
                                getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
                            }else {
                                getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                                display_mode = getResources().getConfiguration().orientation;
                                if(flag && youTubePlayer.isPlaying() && display_mode == Configuration.ORIENTATION_LANDSCAPE ) {
                                    youTubePlayer.pause();
                                    flag = false;
                                }
                            }

                        }
                    });

                    youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                        @Override
                        public void onLoading() {

                        }

                        @Override
                        public void onLoaded(String s) {

                        }

                        @Override
                        public void onAdStarted() {

                        }

                        @Override
                        public void onVideoStarted() {
                            display_mode = getResources().getConfiguration().orientation;
                            if (display_mode == Configuration.ORIENTATION_LANDSCAPE) {
                                youTubePlayer.setFullscreen(true);
                            }
                        }

                        @Override
                        public void onVideoEnded() {

                        }

                        @Override
                        public void onError(YouTubePlayer.ErrorReason errorReason) {

                        }
                    });

                    youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
                        @Override
                        public void onPlaying() {
                            display_mode = getResources().getConfiguration().orientation;
                            if (display_mode == Configuration.ORIENTATION_LANDSCAPE) {
                                youTubePlayer.setFullscreen(true);
                            }
                        }

                        @Override
                        public void onPaused() {

                        }

                        @Override
                        public void onStopped() {

                        }

                        @Override
                        public void onBuffering(boolean b) {

                        }

                        @Override
                        public void onSeekTo(int i) {

                        }
                    });

                    if(savedInstanceState==null)
                        youTubePlayer.cueVideo(VIDEO_ID);

                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                String errorMessage = youTubeInitializationResult.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
                Log.d("erroMessage:", errorMessage);

            }
        });

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_luiz_estevao,menu);
    }

}
