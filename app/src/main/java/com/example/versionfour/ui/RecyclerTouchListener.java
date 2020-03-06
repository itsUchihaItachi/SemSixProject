package com.example.versionfour.ui;

import android.content.Context;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by augmentdeck04 on 2/5/2017.
 */
public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

 private static String TAG = RecyclerTouchListener.class.getSimpleName();

 @SuppressWarnings("EmptyMethod")
 public interface ClickListener {
  void onClick(View view, int position);

  void onLongClick(View view, int position);
 }

 private GestureDetector gestureDetector;
 private ClickListener clickListener;

 public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
  this.clickListener = clickListener;
  gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
   @Override
   public boolean onSingleTapUp(MotionEvent e) {

    // Log.e(TAG,"onSingleTapUp  --------->" );
    return true;
   }

   @Override
   public void onLongPress(MotionEvent e) {
    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
    if (child != null && clickListener != null) {
     clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
    }
   }
  });
 }

 @Override
 public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

  //  Log.e(TAG,"onInterceptTouchEvent  --------->" );

  View child = rv.findChildViewUnder(e.getX(), e.getY());
  if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {

   //   Log.e(TAG,"onInterceptTouchEvent if --------->" );
   clickListener.onClick(child, rv.getChildAdapterPosition(child));
  }
  return false;
 }

 @Override
 public void onTouchEvent(RecyclerView rv, MotionEvent e) {
 }

 @Override
 public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

 }

}
