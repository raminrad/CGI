var endpoints = {
	'datacenters' : 'http://localhost:8080/datacenter-inventory/rest/datacenter',
	'updateOperation' : 'http://localhost:8080/datacenter-inventory/rest/datacenter/1/quarter'
};

(function ($) {
	$(document).ready(function() {
		$('.login-btn').click(function(evt) {
			evt.preventDefault();
			
			if (validateLogin()) {
				navigate('.main-menu');
				$('.logout-link').show();
			}
			else {
				$('.incorrect').show();
			}
		});

		$('.main-menu a').click(function(evt) {
			evt.preventDefault();
			navigate('.' + $(this).attr('dest'));

			// capture which operation we are selecting a data center for
			if ($(this).attr('operation') == 'update') {
				$('.data-center-selection').addClass('update-inventory');
			}
			if ($(this).attr('operation') == 'audit') {
				$('.data-center-selection').addClass('audit-trail');
			}
		});

		$('.audit-trail a').click(function(evt) {
			evt.preventDefault();
			$(this).get()
		});

		$.get(endpoints.datacenters, function(data) {			     
			     //var records = data.data[0].quarterlyData;
			     var records = data.data;

			     var output = '<table class="table table-bordered table-striped"><thead><tr><th>ID</th><th>Fiscal Year</th><th>Quarter</th><th>Closing Stage</th></tr></thead>';

			     output += '<tbody>';
			     for (var i = 0; i < records.length; i++) {
			     	for (var j = 0; j < records[i].quarterlyData.length; j++) {
				     	output += '<tr>';
				     	
				     	output += '<td>' + records[i].quarterlyData[j].id + '</td>';
				     	output += '<td>' + records[i].quarterlyData[j].fiscalYear + '</td>';
				     	output += '<td>' + records[i].quarterlyData[j].quarter + '</td>';
				     	output += '<td>' + records[i].quarterlyData[j].closingStage + '</td>';

				     	output += '</tr>';
			     	}
			     }
			     output += '</tbody>';

			     output += '</table>';

			     $('.audit-trail-screen .content').html(output);
			});

		$('.data-center-selection').on('click', 'a', function(evt) {
			evt.preventDefault();
			if ($(this).parents('.data-center-selection').hasClass('update-inventory')) {
				navigate('.update-form');
			}
			if ($(this).parents('.data-center-selection').hasClass('audit-trail')) {
				navigate('.audit-trail-screen');
			}
		});

		$('.manage-password').click(function(evt) {
			evt.preventDefault();
			navigate('.forgot-password');
		});

		$('.contact-link').click(function(evt) {
			evt.preventDefault();
			navigate('.contact-us');
		});

		$('.navbar-home').click(function(evt) {
			evt.preventDefault();
			navigate('.main-menu');
		});

		$('.update-form form').submit(function(evt) {
			evt.preventDefault();
			$.ajax({
				type: 'POST',
				url: endpoints.updateOperation,
				dataType: "json",
				contentType: "application/json",
				data: JSON.stringify({
					"id" : 1,
					"fiscalYear" : 2016,
					"quarter" : "Q1",
					"fte" : 20.00,
					"fteCost" : 105.00,
					"electricityIndcluded" : false,
					"electricityMetered" : false,
					"totalPowerCapacity" : null,
					"totalItPowerCapacity" : 0.00,
					"averageElectricityUsage" : 0.00,
					"averageItElectricityUsage" : 0.00,
					"costPerKilowattHour" : 100.50,
					"rackCount" : 50,
					"totalIbmMainframes" : 0,
					"totalOtherMainframes" : null,
					"totalWindowsServers" : 2000,
					"totalUnixServers" : 3,
					"totalLinuxServers" : null,
					"totalHpcClusterNodes" : 3,
					"otherServers" : 0,
					"totalVirtualHosts" : 0,
					"totalVirtualOs" : 9,
					"totalStorage" : 1000.00,
					"usedStorage" : 500.00,
					"closingStage" : "Not closing",
					"closingFiscalYear" : null,
					"closingQuarter" : null,
					"realPropertyDisposition" : "test",
					"totalFloorAreaReclaimed" : 2,
					"totalDecomissionedServers" : 1,
					"totalServersMoved" : 100,
					"overallFteReduction" : 7
				})
			});
			alert('hello');
		});
		
		function validateLogin() {
			var userID = $('#userid').val();
			var password = $('#password').val();

			$('.incorrect').hide();

			if (userID === 'admin' && password === 'password') {
				return true;
			}

			return false;
		}

		function navigate(navClass) {
			$('.content-screen').hide();
			$(navClass).show();
			initScreen(navClass);
		}

		function initScreen(navClass) {
			if (navClass == '.data-center-selection') {
				var datacenters = $.ajax({
					url: endpoints.datacenters
				}).success(function(result) {
					console.log(result);
					$.each(result.data, function(key, value) {
						$('.datacenter-list').append(
							'<li>' +
							'<a href="#" datacenter=' + value.id + '>' + value.datacenterInformation.agencyDataCenterId + '</a>' +
							' - ' + value.address.city + ' ' + value.address.state + ', ' + value.address.zip + '</li>'
						);
					});
				});
			}
		}
	});

})(jQuery);
