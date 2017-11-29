package com.example.yhous.beparent.utils

import android.content.Context
import android.graphics.*
import android.view.animation.Transformation
import jp.wasabeef.picasso.transformations.CropCircleTransformation

/**
 * Created by yannickhoussin on 27/11/2017.
 */
class ImageTransformation: CropCircleTransformation() {
  override fun transform(source: Bitmap): Bitmap {
    val size = Math.min(source.width, source.height)

    val width = (source.width - size) / 2
    val height = (source.height - size) / 2

    val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)

    val canvas = Canvas(bitmap)
    val paint = Paint()
    val shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    if (width != 0 || height != 0) {
      // source isn't square, move viewport to center
      val matrix = Matrix()
      matrix.setTranslate((-width).toFloat(), (-height).toFloat())
      shader.setLocalMatrix(matrix)
    }
    paint.shader = shader
    paint.isAntiAlias = true




    val r = size / 2f
    canvas.drawCircle(r, r, r, paint)

    val circlePaint = Paint()
    val ri = size / 2.2f
    circlePaint.style = Paint.Style.STROKE
    circlePaint.strokeWidth = 15f
    circlePaint.color = Color.WHITE
    canvas.drawCircle(r, r, ri, circlePaint)

    source.recycle()

    return bitmap
  }
}