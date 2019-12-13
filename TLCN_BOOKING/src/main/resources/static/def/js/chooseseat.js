$(document).ready(function($) {
	// setting
	var settings = {
	               rows: 4,
	               cols: 7,
	               rowCssPrefix: 'row',
	               colCssPrefix: 'col',
	               seatWidth: 60	,
	               seatHeight: 40,
	               seatCss: 'seat',
	               selectedSeatCss: 'selectedSeat',
	               selectingSeatCss: 'selectingSeat'
	           };

	//set layout
	var init = function (reservedSeat) {
	                var str = [], seatNo, className;
	                for (i = 0; i < settings.rows; i++) {
	                    for (j = 0; j < settings.cols; j++) {
	                        seatNo = (i + j * settings.rows + 1);
	                        className = settings.seatCss + ' ' + settings.rowCssPrefix + i.toString() + ' ' + settings.colCssPrefix + j.toString();
	                        if ($.isArray(reservedSeat) && $.inArray(seatNo, reservedSeat) != -1) {
	                            className += ' ' + settings.selectedSeatCss;
	                        }
	                        str.push('<li class="' + className + '"' +
	                                  'style="top:' + (i * settings.seatHeight).toString() + 'px;left:' + (j * settings.seatWidth).toString() + 'px">' +
	                                  '<a title="' + seatNo + '">' + seatNo + '</a>' +
	                                  '</li>');
	                    }
	                }
	                $('#place').html(str.join(''));
	            };
	            //case I: Show from starting
	            //init();
	 
	            //Case II: If already booked
	            var bookedSeats = [5, 10, 25];
	            init(bookedSeats);  
	            var count=0;        

	//set selection
	$('.' + settings.seatCss).click(function () {
		if ($(this).hasClass(settings.selectedSeatCss)){
		    	alert('This seat is already reserved');
		}
		else{
			if(count<5){
				if ($(this).hasClass(settings.selectingSeatCss)){
					count--;
				}else{
					count++;
				}
			    $(this).toggleClass(settings.selectingSeatCss);
			    var str = [], item;
			    $.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
			        item = $(this).attr('title');                   
			        str.push(item);                   
			    }); 
			    $('#showSeat').text(str.join(' , '));
			    var price=str.length+' x 300.000 = '+(str.length*300000)+' VND';
			   	$("#price").text(price);
			    
			}
			else{
				if ($(this).hasClass(settings.selectingSeatCss)){
					count--;
					$(this).toggleClass(settings.selectingSeatCss);
					var str = [], item;
			    	$.each($('#place li.' + settings.selectingSeatCss + ' a'), function (index, value) {
			        	item = $(this).attr('title');                   
			        	str.push(item);                   
			    	});
			    	$('#showSeat').text(str.join(' , '));
			    	var price=str.length+' x 300.000 = '+(str.length*300000)+' VND';
			   		$("#price").text(price);
				}
				else{
					alert("limited 5 seats");
				}
			}
		}
		
	    	
	});

	
});
