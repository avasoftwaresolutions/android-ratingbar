# Android RatingBar

A simpler RatingBar for Android.

# Installation

In your build.gradle (project), make sure you added the jitpack repository.
```
allprojects {
    repositories {
    ...
    maven { url 'https://jitpack.io' }
    }
}
```

Then add the dependency to your build.gradle (module).
```
dependencies {
    implementation 'com.github.avasoftwaresolutions:android-ratingbar:1.0.0'
 }
```

# Usage

In your layout xml: 

```XML
<com.avasoftwaresolutions.ratingbar.RatingBar
    android:id="@+id/ratingbar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:max_stars="5"
    app:stars="3"
    app:star_drawable="your-drawable"
    app:star_drawable_filled="your-drawable-2"
    app:filled_tint="your-color"
    app:unfilled_tint="your-color-2" />
```

In your Java code:

```
RatingBar ratingBar = findViewById(R.id.ratingbar);
ratingBar.getStars();                                          // Returns the number of selected stars
ratingBar.setStarDrawable(drawable);                           // Sets the drawable of the unselected stars
ratingBar.setStarDrawableFilled(drawable);                     // Sets the drawable of the selected stars
ratingBar.setFilledTint(color);                                // Sets the color of the selected stars
ratingBar.setUnfilledTint(color);                              // Sets the color of the unselected stars
ratingBar.setOnClickListener(listener);                        // Sets an OnClickListener
```

# License

MIT License

Copyright (c) 2019 AVA Software Solutions

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
