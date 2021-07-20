geometrics: main
figure clock{
	circle base1 (0,0) 5
	line pointerMinutes (0,0) (0,4)
	line pointerHours (0,0) (5,0)
}

animation clockMin{
	tick is 60000					/* define tick in ms */
	loop 60 times
	rotate pointerMinutes 30 		/*rotation in degrees (positive by default */
}

animation clockHour {
	tick is 360000					/* define tick in ms */
	loop 24 times
	rotate pointerHours 30
}

add clockMin to clock
add clockHour to clock

