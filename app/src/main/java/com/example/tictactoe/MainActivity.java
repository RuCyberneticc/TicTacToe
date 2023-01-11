package com.example.tictactoe;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    static boolean COUNT, END;
    static int ENDGAME = 0;
    static int width;
    static int height;
    static int length;
    static int starty = 682;
    static int startx = 50;
    static int cell;
    public static int[] matrix = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static float[][][] elements = new float[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}};
    public MyDraw content;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        COUNT = false;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        content = new MyDraw(this);
        setContentView(content);
        content.setOnTouchListener(this);
        //setContentView(R.layout.activity_main);
    }

    public static void checkWinner() {
        System.out.println("IN CHECKWINNER");
        if ((matrix[0] == 1 && matrix[3] == 1 && matrix[6] == 1) ||
                (matrix[1] == 1 && matrix[4] == 1 && matrix[7] == 1) ||
                (matrix[2] == 1 && matrix[5] == 1 && matrix[8] == 1) ||
                (matrix[0] == 1 && matrix[1] == 1 && matrix[2] == 1) ||
                (matrix[3] == 1 && matrix[4] == 1 && matrix[5] == 1) ||
                (matrix[6] == 1 && matrix[7] == 1 && matrix[8] == 1) ||
                (matrix[0] == 1 && matrix[4] == 1 && matrix[8] == 1) ||
                (matrix[2] == 1 && matrix[4] == 1 && matrix[6] == 1)) {
            ENDGAME = 1;
        } else if ((matrix[0] == 2 && matrix[3] == 2 && matrix[6] == 2) ||
                        (matrix[1] == 2 && matrix[4] == 2 && matrix[7] == 2) ||
                        (matrix[2] == 2 && matrix[5] == 2 && matrix[8] == 2) ||
                        (matrix[0] == 2 && matrix[1] == 2 && matrix[2] == 2) ||
                        (matrix[3] == 2 && matrix[4] == 2 && matrix[5] == 2) ||
                        (matrix[6] == 2 && matrix[7] == 2 && matrix[8] == 2) ||
                        (matrix[0] == 2 && matrix[4] == 2 && matrix[8] == 2) ||
                        (matrix[2] == 2 && matrix[4] == 2 && matrix[6] == 2)) {
            ENDGAME = 2;
        } else if ((matrix[0] == 1 || matrix[0] == 2) &&
                (matrix[1] == 1 || matrix[1] == 2) &&
                (matrix[2] == 1 || matrix[2] == 2) &&
                (matrix[3] == 1 || matrix[3] == 2) &&
                (matrix[4] == 1 || matrix[4] == 2) &&
                (matrix[5] == 1 || matrix[5] == 2) &&
                (matrix[6] == 1 || matrix[6] == 2) &&
                (matrix[7] == 1 || matrix[7] == 2) &&
                (matrix[8] == 1 || matrix[8] == 2)) {
            ENDGAME = 3;
        }
    }



    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouch(View view, MotionEvent event) {
        System.out.println(COUNT);
        float x = event.getX();
        float y = event.getY();
        if (x >= startx && x <= cell + startx && y >= starty && y <= starty + cell) {
            if (matrix[0] == 0) {
                if (COUNT) {
                    elements[0][0] = new float[]{startx + 40, starty + 40, startx + cell - 40, starty + cell - 40}; // 90
                    elements[0][1] = new float[]{startx + cell - 40, starty + 40, startx + 40, starty + cell - 40}; // 457
                    matrix[0] = 1;
                } else {
                    elements[0][2] = new float[]{cell / 2 + startx, starty + cell / 2, cell / 2 - 30};
                    matrix[0] = 2;
                }
                COUNT = !COUNT;
            }
        }
        else if (x >= cell + startx && x <= cell * 2 + startx && y >= starty && y <= starty + cell) {
            if (matrix[1] == 0) {
                if (COUNT) {
                    elements[1][0] = new float[]{startx + cell + 40, starty + 40, startx + cell * 2 - 40, starty + cell - 40}; // 537
                    elements[1][1] = new float[]{startx + cell * 2 - 40, starty + 40, startx + cell + 40, starty + cell - 40}; // 904
                    matrix[1] = 1;
                } else {
                    elements[1][2] = new float[]{cell / 2 + cell + startx, starty + cell / 2, cell / 2 - 30};
                    matrix[1] = 2;
                }
                COUNT = !COUNT;
            }
        }
        else if (x >= cell * 2 + startx && x <= cell * 3 + startx && y >= starty && y <= starty + cell) {
            if (matrix[2] == 0) {
                if (COUNT) {
                    elements[2][0] = new float[]{startx + cell * 2 + 40, starty + 40, startx + cell * 3 - 40, starty + cell - 40};
                    elements[2][1] = new float[]{startx + cell * 3 - 40, starty + 40, startx + cell * 2 + 40, starty + cell - 40};
                    matrix[2] = 1;
                } else {
                    elements[2][2] = new float[]{cell / 2 + 2 * cell + startx, starty + cell / 2, cell / 2 - 30};
                    matrix[2] = 2;
                }
                COUNT = !COUNT;
            }
        }
        else if (x >= startx && x <= cell + startx && y >= starty + cell && y <= starty + cell * 2) {
            if (matrix[3] == 0) {
                if (COUNT) {
                    elements[3][0] = new float[]{startx + 40, starty + cell + 40, startx + cell - 40, starty + cell * 2 - 40};
                    elements[3][1] = new float[]{startx + cell - 40, starty + cell + 40, startx + 40, starty + cell * 2 - 40};
                    matrix[3] = 1;
                } else {
                    elements[3][2] = new float[]{cell / 2 + startx, starty + cell / 2 + cell, cell / 2 - 30};
                    matrix[3] = 2;
                }
                COUNT = !COUNT;
            }
        }
        else if (x >= cell + startx && x <= cell * 2 + startx && y >= starty + cell && y <= starty + cell * 2) {
            if (matrix[4] == 0) {
                if (COUNT) {
                    elements[4][0] = new float[]{startx + cell + 40, starty + cell + 40, startx + cell * 2 - 40, starty + cell * 2 - 40};
                    elements[4][1] = new float[]{startx + cell * 2 - 40, starty + cell + 40, startx + cell + 40, starty + cell * 2 - 40};
                    matrix[4] = 1;
                } else {
                    elements[4][2] = new float[]{cell / 2 + cell + startx, starty + cell / 2 + cell, cell / 2 - 30};
                    matrix[4] = 2;
                }
                COUNT = !COUNT;
            }
        }
        else if (x >= cell * 2 + startx && x <= cell * 3 + startx && y >= starty + cell && y <= starty + cell * 2) {
            if (matrix[5] == 0) {
                if (COUNT) {
                    elements[5][0] = new float[]{startx + cell * 2 + 40, starty + cell + 40, startx + cell * 3 - 40, starty + cell * 2 - 40};
                    elements[5][1] = new float[]{startx + cell * 3 - 40, starty + cell + 40, startx + cell * 2 + 40, starty + cell * 2 - 40};
                    matrix[5] = 1;
                } else {
                    elements[5][2] = new float[]{cell / 2 + 2 * cell + startx, starty + cell / 2 + cell, cell / 2 - 30};
                    matrix[5] = 2;
                }
                COUNT = !COUNT;
            }
        }
        else if (x >= startx && x <= cell + startx && y >= starty + cell * 2 && y <= starty + cell * 3) {
            if (matrix[6] == 0) {
                if (COUNT) {
                    elements[6][0] = new float[]{startx + 40, starty + cell * 2 + 40, startx + cell - 40, starty + cell * 3 - 40};
                    elements[6][1] = new float[]{startx + cell - 40, starty + cell * 2 + 40, startx + 40, starty + cell * 3 - 40};
                    matrix[6] = 1;
                } else {
                    elements[6][2] = new float[]{cell / 2 + startx, starty + cell / 2 + cell * 2, cell / 2 - 30};
                    matrix[6] = 2;
                }
                COUNT = !COUNT;
            }
        }
        else if (x >= cell + startx && x <= cell * 2 + startx && y >= starty + cell * 2 && y <= starty + cell * 3) {
            if (matrix[7] == 0) {
                if (COUNT) {
                    elements[7][0] = new float[]{startx + cell + 40, starty + cell * 2 + 40, startx + cell * 2 - 40, starty + cell * 3 - 40};
                    elements[7][1] = new float[]{startx + cell * 2 - 40, starty + cell * 2 + 40, startx + cell + 40, starty + cell * 3 - 40};
                    matrix[7] = 1;
                } else {
                    elements[7][2] = new float[]{cell / 2 + cell + startx, starty + cell / 2 + cell * 2, cell / 2 - 30};
                    matrix[7] = 2;
                }
                COUNT = !COUNT;
            }
        }
        else if (x >= cell * 2 + startx && x <= cell * 3 + startx && y >= starty + cell * 2 && y <= starty + cell * 3) {
            if (matrix[8] == 0) {
                if (COUNT) {
                    elements[8][0] = new float[]{startx + cell * 2 + 40, starty + cell * 2 + 40, startx + cell * 3 - 40, starty + cell * 3 - 40};
                    elements[8][1] = new float[]{startx + cell * 3 - 40, starty + cell * 2 + 40, startx + cell * 2 + 40, starty + cell * 3 - 40};
                    matrix[8] = 1;
                } else {
                    elements[8][2] = new float[]{cell / 2 + 2 * cell + startx, starty + cell / 2 + cell * 2, cell / 2 - 30};
                    matrix[8] = 2;
                }
                COUNT = !COUNT;
            }
        }
        return false;
    }

    public static class MyDraw extends View{
        public Paint paint;
        public MyDraw(Context context) {
            super(context);
        }
        @SuppressLint("DrawAllocation")
        @Override
        protected void onDraw(Canvas canvas) {
            if (END) {
                try {
                    Thread.sleep(5000);
                } catch (Exception ignored) {}
                END = false;
            }
            super.onDraw(canvas);
            paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(25);
            width = getWidth();
            height = getHeight();
            length = width - 100;
            starty = (height - length) / 2;
            cell = length / 3;
            System.out.println(starty);
            canvas.drawLine(startx, starty + length / 3, width - startx, starty + length / 3, paint); // horizontal 1
            canvas.drawLine(startx, starty + 2 * length / 3, width - startx, starty + 2 * length / 3, paint); // horizontal 2
            canvas.drawLine(startx + length / 3, starty, startx + length / 3, starty + length, paint); // vertical 1
            canvas.drawLine(startx + 2 * length / 3, starty, startx + 2 * length / 3, starty + length, paint); // vertical 2
            System.out.println(ENDGAME);
            for (int i = 0; i < 9; i++) {
                if (matrix[i] == 1) {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setStrokeWidth(15);
                    paint.setColor(Color.RED);
                    canvas.drawLine(elements[i][0][0], elements[i][0][1], elements[i][0][2], elements[i][0][3], paint);
                    canvas.drawLine(elements[i][1][0], elements[i][1][1], elements[i][1][2], elements[i][1][3], paint);
                } else if (matrix[i] == 2) {
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(15);
                    paint.setColor(Color.BLUE);
                    canvas.drawCircle(elements[i][2][0], elements[i][2][1], elements[i][2][2], paint);
                }
            }
            if (ENDGAME == 1) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.WHITE);
                canvas.drawPaint(paint);
                paint.setColor(Color.RED);
                paint.setStrokeWidth(25);
                canvas.drawLine(startx + cell / 2, starty, startx + cell * 2 + cell / 2, starty + cell * 2, paint);
                canvas.drawLine(startx + cell * 2 + cell / 2, starty, startx + cell / 2, starty + cell * 2, paint);
                paint.setTextSize(100);
                int w = (int) paint.measureText("CROSSES WON");
                canvas.drawText("CROSSES WON", width / 2 - w / 2, starty + cell * 3, paint);
                ENDGAME = 0;
                matrix = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
                elements = new float[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}};
                COUNT = false;
                try {
                    Thread.sleep(5000);
                } catch (Exception ignored) {}
                END = true;
            } else if (ENDGAME == 2) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.WHITE);
                canvas.drawPaint(paint);
                paint.setColor(Color.BLUE);
                paint.setStrokeWidth(25);
                canvas.drawCircle(width / 2, starty + cell, cell, paint);
                paint.setTextSize(100);
                int w = (int) paint.measureText("CIRCLES WON");
                canvas.drawText("CIRCLES WON", width / 2 - w / 2, starty + cell * 3, paint);
                ENDGAME = 0;
                matrix = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
                elements = new float[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}};
                COUNT = false;
                try {
                    Thread.sleep(5000);
                } catch (Exception ignored) {}
                END = true;
            } else if (ENDGAME == 3) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.WHITE);
                canvas.drawPaint(paint);
                paint.setColor(Color.BLUE);
                paint.setStrokeWidth(25);
                canvas.drawCircle(width / 2, starty + cell, cell, paint);
                paint.setColor(Color.RED);
                canvas.drawLine(startx + cell / 2, starty, startx + cell * 2 + cell / 2, starty + cell * 2, paint);
                canvas.drawLine(startx + cell * 2 + cell / 2, starty, startx + cell / 2, starty + cell * 2, paint);
                paint.setTextSize(100);
                int w = (int) paint.measureText("DRAW");
                canvas.drawText("DRAW", width / 2 - w / 2, starty + cell * 3, paint);
                ENDGAME = 0;
                matrix = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
                elements = new float[][][]{{{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}, {{}, {}, {}}};
                COUNT = false;
                try {
                    Thread.sleep(5000);
                } catch (Exception ignored) {}
                END = true;
            }
            invalidate();
            checkWinner();
        }

    }


}

