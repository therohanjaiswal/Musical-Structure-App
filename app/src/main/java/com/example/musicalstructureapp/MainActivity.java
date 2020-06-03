package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Song> songList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        songList = new ArrayList<Song>();
        songList.add(new Song(R.drawable.kabir_singh,"Tujhe Kitna Chahe aur","Jubin Nautiyal"));
        songList.add(new Song(R.drawable.aankh_maare,"Aankh Maare","Mika Singh"));
        songList.add(new Song(R.drawable.chogada,"Chogada","Jubin Nautiyal"));
        songList.add(new Song(R.drawable.coca_cola,"Coca Cola","Tony Kakkar"));
        songList.add(new Song(R.drawable.jaani_teri_na,"Jaani Teri Na","Sunandha"));
        songList.add(new Song(R.drawable.kaabil,"Kaabil Hoon","Jubin Nautiyal"));
        songList.add(new Song(R.drawable.ve_maahi,"Ve Maahi","Arijit Singh"));
        songList.add(new Song(R.drawable.kya_baat_ay,"Kya Baat Ay","Hardy Sandhu"));
        songList.add(new Song(R.drawable.vaaste,"Vaaste","Dhvani Bhanushali"));
        songList.add(new Song(R.drawable.tum_hi_ana,"Tum Hi Ana","Jubin Nautiyal"));

        final SongAdapter songAdapter = new SongAdapter(this, songList);
        final ListView songListView = findViewById(R.id.listView);
        songListView.setAdapter(songAdapter);
        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song currentSong = (Song) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("song_image", currentSong.getImageId());
                intent.putExtras(bundle);
                intent.putExtra("song_name", currentSong.getSongName());
                intent.putExtra("artist", currentSong.getArtistName());
                startActivity(intent);
            }
        });
    }
}
