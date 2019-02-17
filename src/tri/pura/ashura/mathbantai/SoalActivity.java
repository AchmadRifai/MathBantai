package tri.pura.ashura.mathbantai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoalActivity extends Activity {
	private TextView level, soal, point;
	private int lvl, nilai, js;
	private Button pilA, pilB, pilC, pilD;
	private Soal s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        binding();
        muat();
        evene();
    }

	private void evene() {
		pilA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				jawab(1);
			}
		}); pilB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				jawab(2);
			}
		}); pilC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				jawab(3);
			}
		}); pilD.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				jawab(4);
			}
		});
	}

	private void jawab(int i) {
		if (s.benar(i)) {
			nilai += lvl * 50;
			muat();
		} else kalah();
	}

	private void kalah() {
		pindah();
	}

	private void pindah() {
		startActivity(new Intent(this, HasilActivity.class));
		finish();
	}

	private void muat() {
		js++;
		if (js == 5) {
			lvl++;
			js = 0;
		} s = new Soal(lvl);
		pilA.setText("A. " + s.getPilA());
		pilB.setText("B. " + s.getPilB());
		pilC.setText("C. " + s.getPilC());
		pilD.setText("D. " + s.getPilD());
		soal.setText("" + s);
		level.setText("Level : " + lvl);
		point.setText("" + nilai + " points");
	}

	private void binding() {
		level = (TextView) findViewById(R.id.level);
		soal = (TextView) findViewById(R.id.soal);
		point = (TextView) findViewById(R.id.point);
		lvl = 1;
		js = 0;
		nilai = 0;
		pilA = (Button) findViewById(R.id.pilA);
		pilB = (Button) findViewById(R.id.pilB);
		pilC = (Button) findViewById(R.id.pilC);
		pilD = (Button) findViewById(R.id.pilD);
	}
}
