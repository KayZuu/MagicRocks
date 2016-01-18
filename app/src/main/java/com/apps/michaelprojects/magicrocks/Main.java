package com.apps.michaelprojects.magicrocks;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends ActionBarActivity {

    public Button[] btPedra = new Button[4];
    public Button btStart;
    public int[] sequencia = new int[51];
    public int tentativa;
    public int[] imagensHover = new int[]{R.drawable.bt_pedra1_hover,
            R.drawable.bt_pedra2_hover,
            R.drawable.bt_pedra3_hover,
            R.drawable.bt_pedra4_hover};
    public int[] imagensNormal = new int[]{R.drawable.bt_pedra1,
            R.drawable.bt_pedra2,
            R.drawable.bt_pedra3,
            R.drawable.bt_pedra4};
    public int jogada, contador, acertos = 0;
    public Random random = new Random();
    public Handler handler = new Handler();
    public boolean btPressionado;
    public TextView[] tvFinais = new TextView[3];
    public int setar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btPedra[0] = (Button)findViewById(R.id.btPedra0);
        btPedra[1] = (Button)findViewById(R.id.btPedra1);
        btPedra[2] = (Button)findViewById(R.id.btPedra2);
        btPedra[3] = (Button)findViewById(R.id.btPedra3);
        btStart = (Button)findViewById(R.id.btStart);
        tvFinais[0] = (TextView)findViewById(R.id.tvFinal);
        tvFinais[1] = (TextView)findViewById(R.id.tvAcertos);
        tvFinais[2] = (TextView)findViewById(R.id.tvNumAcertos);


        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFinais[0].setVisibility(View.INVISIBLE);
                tvFinais[1].setVisibility(View.INVISIBLE);
                tvFinais[2].setVisibility(View.INVISIBLE);
                jogada = 1;
                btStart.setBackgroundResource(R.drawable.btstart_hover);
                btStart.setEnabled(false);
                setSequencia();
                btPressionado = false;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btStart.setVisibility(View.INVISIBLE);
                                inicioJogo();
                            }
                        });
                    }
                }).start();

            }
        });

        btPedra[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tentativa = 0;
            }
        });

        btPedra[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[1].setBackgroundResource(imagensHover[1]);
                                tentativa = 1;
                            }
                        });
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[1].setBackgroundResource(imagensNormal[1]);
                                btPressionado = true;
                            }
                        });
                    }
                }).start();
            }
        });

        btPedra[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[2].setBackgroundResource(imagensHover[2]);
                                tentativa = 2;
                            }
                        });
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[2].setBackgroundResource(imagensNormal[2]);
                                btPressionado = true;
                            }
                        });
                    }
                }).start();
            }
        });

        btPedra[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[3].setBackgroundResource(imagensHover[3]);
                                tentativa = 3;
                            }
                        });
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[3].setBackgroundResource(imagensNormal[3]);
                                btPressionado = true;
                            }
                        });
                    }
                }).start();
            }
        });




    }
    public void setSequencia(){
        for (int i = 0; i < 50; ++i){
            sequencia[i] = random.nextInt(4);
        }
    }

    public void inicioJogo() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; jogada <= 50; jogada++) {
                    for (contador = 0; contador < jogada; contador++) {
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[sequencia[contador]].setBackgroundResource(imagensHover[sequencia[contador]]);
                            }
                        });
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[sequencia[contador]].setBackgroundResource(imagensNormal[sequencia[contador]]);
                            }
                        });
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (setar = 0; setar < btPedra.length; ++setar){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[setar].setEnabled(true);
                            }
                        });
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (contador = 0; contador < jogada; ++contador){

                        while (!btPressionado) {
                            try {
                                Thread.sleep(150);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        if (tentativa == sequencia[contador]){
                            acertos++;
                            btPressionado = false;
                        } else {
                            gameOver();
                        }
                    }

                    for (setar = 0; setar < btPedra.length; ++setar){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btPedra[setar].setEnabled(true);
                            }
                        });
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    public void gameOver(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvFinais[0].setText(R.string.perdeu);
                        tvFinais[0].setVisibility(View.VISIBLE);
                        tvFinais[1].setVisibility(View.VISIBLE);
                        tvFinais[2].setText(""+acertos);
                        tvFinais[2].setVisibility(View.VISIBLE);
                        jogada = 51;
                        contador = 51;
                        btStart.setEnabled(true);
                        btStart.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();


    }



}
