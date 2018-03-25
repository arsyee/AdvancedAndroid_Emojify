package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import android.util.Log;
import android.util.SparseArray;

class Emojifier {

    private static final String TAG = Emojifier.class.getSimpleName();

    static int detectFaces(Context context, Bitmap bitmap) {
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();
        if (!detector.isOperational()) {
            Log.e(TAG, "FaceDetector is not operational!");
        }
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = detector.detect(frame);
        detector.release();
        int countFaces = faces.size();
        Log.i(TAG, String.format("Number of faces detected: %d", countFaces));
        return countFaces;
    }

}
