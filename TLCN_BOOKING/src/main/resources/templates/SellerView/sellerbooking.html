<%@page import="busticket.dto.SeatDetail"%>
<%@page import="busticket.service.ProfileCustomerService"%>
<%@page import="busticket.service.UserService"%>
<%@page import="busticket.model.Ticket"%>
<%@page import="busticket.model.ProfileCustomer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="busticket.model.Session"%>
<%@page import="busticket.model.Route"%>
<%@page import="busticket.model.Car"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/def/images/icon.ico">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="${pageContext.request.contextPath}/def/vendor/jquery/jquery.dataTables.min.css" rel="stylesheet" id="bootstrap-css"> 
    <script src="${pageContext.request.contextPath}/def/vendor/bootstrap/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.js"></script>
    <script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/def/vendor/jquery/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/def/js/awesome.js"></script>
    <style> 
        table {
            border-collapse: collapse;
            width: 100%;
        }

        td {
            max-width: 100px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        th, td {
          padding: 8px;
          text-align: left;
          border-bottom: 1px solid #ddd;
        }
    </style>  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/sellerstyle.css">  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/def/css/booking-ticket.css"> 
	<title>Booking Ticket</title>
</head>
<%
	Session thisSession = (Session) session.getAttribute("thisSession");
	ArrayList<ProfileCustomer> listCustomer = (ArrayList<ProfileCustomer>) session.getAttribute("listCustomer");
	ArrayList<SeatDetail> listSeatBooked = (ArrayList<SeatDetail>) session.getAttribute("lst_idSeat");
	int countbill =0;
	
	int tickets= 5-countbill;
	Route r = (Route) session.getAttribute("choosedRoute");
%>
<body>
	<div class="container-fluid">
            
        <div class="row">
            <div class="col-2 wrapper">
                <div class="sidebar nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <a href="SellerHome" style="text-decoration: none;"><h2>Seller</h2></a>
                        <a href="SellerHome" class="nav-link ">Profile Seller</a>
                        <a href="ManageRoute" class="nav-link active">Route management</a>
                        <a href="Logout" class="nav-link">Log out</a>
                </div>
            </div>

            <div class="col-10">
                <nav class="nav-menu" style="padding-bottom:30px">  
                     <form action="EditRoute" method="post" style="float:left;"><input type='hidden' name='getSession' value='<%=thisSession.getId()%>'/><button type="submit" class="btn btn-primary back-route-management"> <i class="fas fa-angle-left"></i> Back</button></form> 
                     <!-- <input class="form-control" id="myInput" type="text" placeholder="Search.." style="float: right; width:40%; ">   -->                  
                </nav>

                <div class="route">
                    <div class="route-date"">
                        <div style="float: left;">
                            <i class="fas fa-clock"></i>
                        </div>                            
                        <div class="time" >
                            <div class="label-time">Time: </div>
                            <div><%=thisSession.getRouteObject().getTimeStarting() %></div>
                            <div class="fas fa-arrow-right"></div>
                            <div><%=thisSession.getRouteObject().getTimeFinishing() %></div>
                            <div class="date"><b>Date:</b>  <%=thisSession.getDepartDate() %></div>
                        </div>  
                    </div>

                    <div class="route-point">
                        <div class=" fas fa-map-marked-alt" id="icon"></div>
                        <div class="label-route">Route: </div>
                        <div><%=thisSession.getRouteObject().getStartingPoint() %></div>
                        <div class="fas fa-arrow-right"></div>
                        <div><%=thisSession.getRouteObject().getDestination() %></div>
                    </div>

                    <div class="route-car">
                        <div class="fas fa-bus" id="icon"></div>
                        <div class="car">
                            <div><b>Car ID:</b> <%=thisSession.getCarObject().getId() %></div>
                            <div><b>Car Name:</b> <%=thisSession.getCarObject().getCarName() %></div>
                        </div>
                    </div>

                    <div class="route-booked-ticket" style="float:left">
                        <i class="fas fa-ticket-alt"></i>

                        <span><b>Booked Tickets: </b></span>
                        <span><%=thisSession.getTicketNumber() %> tickets</span>
                    </div>
                </div> 
                <div class="row">
                    <div class="col-5">
                        <div id="title"> Choose seats below:</div>
                        <div id="holder">
                            <ul id="place"></ul>
                        </div>

                        <div id="seatDescription" style="height:60px"> 
                            <ul>
                                <li>
                                    <img src="${pageContext.request.contextPath}/def/images/available.png">
                                    <div>Available Seat</div>
                                </li>
                                <li>
                                    <img src="${pageContext.request.contextPath}/def/images/booked.png">
                                    <div>Booked Seat</div>
                                </li>
                                <li>
                                    <img src="${pageContext.request.contextPath}/def/images/selection.png">
                                    <div>Selected Seat</div>
                                </li>
                            </ul>

                        </div>
                        <div class="infobill">
                                <div id="title">Seat ID: 
                                    <div id="showSeat"></div>
                                </div>
                                <div id="title">Price
                                    <div id="price"></div>
                                </div>
                            </div>
                    </div>
                    <div class="col-7" >
                    	<form class="form" action="SellerBookTicket" method="POST">
	                        <table id="data-cus">
	                        </table>
	                        <input id="s1" type="hidden" name="seat1">
		        			<input id="s2" type="hidden" name="seat2">
		        			<input id="s3" type="hidden" name="seat3">
		        			<input id="s4" type="hidden" name="seat4">
		        			<input id="s5" type="hidden" name="seat5">
                            <input class="btn btn-primary" id="btn-next" type="submit" value="Confirm" onclick="return confirm('Are you sure you want to book ticket?')" >
                        </form>
                    </div>  
                </div>
            </div>
        </div>
    </div>

    <script>
        var dataSet = [
        	<%for (ProfileCustomer x : listCustomer){ %>
	            ["<%=x.getId()%>",
	            "<%=x.getCustomerName()%>",
	            "<%=x.getPhoneNumber()%>",
	            "<%=ProfileCustomerService.getEmailById(x.getId())%>",
	            "<input name='radio-cus' value='<%=x.getId()%>' type='radio'>"
	            ],
	        <%}%>
        ];

        $(document).ready(function(){
            $('#data-cus').DataTable({
                data: dataSet,
                columns:[
                    { title: "ID"},
                    { title: "Name"},
                    { title: "Phone Number"},
                    { title: "Email"},
                    { defaultContent: ""}
                ]
            });
        })
    </script>
    <script>
	$(document).ready(function() {
		$('#btn-next').attr('disabled','disabled');
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
		            var bookedSeats = [<%for(SeatDetail sd:listSeatBooked){
		            	out.print(sd.getNameSeat()+",");
		            }%>];
		            init(bookedSeats);  
		            var count=0;        

		//set selection
		var listTicket=[];
		$('.' + settings.seatCss).click(function () {
			if ($(this).hasClass(settings.selectedSeatCss)){
			    	alert('This seat is already reserved');
			}
			else{
				if(count<<%=tickets%>){
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
				    var price=str.length+' x <%=r.getPrice()%> = '+(str.length*<%=r.getPrice()%>)+' VND';
				   	$("#price").text(price);
				   	listTicket=str;
				    
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
				    	var price=str.length+' x <%=r.getPrice()%> = '+(str.length*<%=r.getPrice()%>)+' VND';
				   		$("#price").text(price);
				   		listTicket=str;
					}
					else{
						alert("limited 5 seats");
					}
				}
			}
			var i;
			for(i=0;i<5;i++){
				$("#s"+(i+1)+"").val("");
			}
			for(i=0;i<listTicket.length;i++){
				$("#s"+(i+1)+"").val(listTicket[i]);
			}
			if(listTicket.length==0){
				$('#btn-next').attr('disabled','disabled');
			}else{
				$('#btn-next').removeAttr('disabled');
			}	
		});
		
		
	});

	</script>
    <script>
        function getRadioButton(){
            var checkbox = document.getElementsByName("radio-cus");
            val = $("input[name='radio-cus']:checked").val();
            /*if (checkbox[i].checked === true){
                ord = val.slice(4,val.length);
                alert(dataSet[ord][0]);
            }*/
            ord = val.slice(4,val.length);
            var tmp = 0;
            for (i=0; i<checkbox.length; i++){
            	if (ord === dataSet[i][0]){
            		tmp = i;
            		break;
            	}
            }
        }
    </script>
</body>
</html>