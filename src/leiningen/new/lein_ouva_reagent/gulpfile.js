var gulp = require('gulp');
var stylus = require('gulp-stylus');
var watchify = require('watchify'); 
var Hjson = require('gulp-hjson');

gulp.task('json', function() {
  gulp.src(['./data/*.hson'])
    .pipe(Hjson({ to: 'json' }))
    .pipe(gulp.dest('./data'));
});

gulp.task('stylus', function() {
  gulp.src(['./resources/public/css/*.styl'])
    .pipe(stylus())
    .pipe(gulp.dest('./resources/public/css'))
});

gulp.task('watch', function() {
  gulp.watch('./resources/public/css/*.styl', ['stylus']);
  gulp.watch('./resources/public/data/*.hson', ['json']);
});



gulp.task('default', ['stylus', 'json', 'watch']);
