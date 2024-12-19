<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='./dist/index.global.js'></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		
		//let eventData; console.log('1',eventData)
		// eventData 에 저장하기 fullData.do
		fetch('fullData.do')
		// .then(function(result) {return result.json()}) 이렇게도 쓸수있음
		.then(result => result.json())
		.then(result => {
			// console.log(result);
		    eventData = result;
			var calendarEl = document.getElementById('calendar');
			
			var calendar = new FullCalendar.Calendar(calendarEl, {
				headerToolbar: {
					left: 'prev,next today',
					center: 'title',
					right: 'dayGridMonth,timeGridWeek,timeGridDay'
				},
				initialDate: '2024-12-12',
				navLinks: true, // can click day/week names to navigate views
				selectable: true,
				selectMirror: true,
				select: function(arg) {
					var title = prompt('이벤트를 등록하세요:');
					if (title) {
						console.log(arg); // arg 확인.......
						// Ajax 호출.
						fetch('addEvent.do?a=' + title + '&b=' + arg.startStr + '&c=' + arg.endStr)
						.then(result => result.json())
						.then(result => {
							// 화면 출력
							if(result.retCode == 'OK') {
								calendar.addEvent({
									title: title,
									start: arg.start,
									end: arg.end,
									allDay: arg.allDay
								})
							} // end of retCoed == 'OK'
						})
			     		.catch(err => console.log(err));
					}
					calendar.unselect();
				},
				eventClick: function(arg) {
					var e = arg.event;
					if (confirm('이벤트를 삭제합니까?')) {
						//arg.event.remove() // 화면에서 이벤트 지우기.
						fetch('deleteEvent.do?a=' + e.title + '&b=' + e.startStr + '&c=' + e.endStr)
						.then(result => result.json())
						.then(result => {
							// 화면 삭제
							if(result.retCode == 'OK') {
								console.log("DB에서 지우기 성공");
							    arg.event.remove();			
							}
						})
					}
			    },
				editable: true,
				dayMaxEvents: true, // allow "more" link when too many events
				events: eventData // [{},{},{}, .....{}] 
			});
			
			calendar.render();
		})
		.catch(err => console.log(err));
	});
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>
