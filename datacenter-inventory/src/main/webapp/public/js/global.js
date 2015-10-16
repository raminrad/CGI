var endpoints = {
	'datacenters' : 'js/Datacenters.json'
};

(function ($) {
	$(document).ready(function() {
		$('.login-btn').click(function(evt) {
			evt.preventDefault();
			
			if (validateLogin()) {
				navigate('.main-menu');
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

		$('.data-center-selection a').click(function(evt) {
			evt.preventDefault();
			if ($(this).hasClass('update-inventory')) {
				navigate('.update-form');
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
							'<a href="/update/' + value.id + '" datacenter=' + value.id + '>' + value.datacenterInformation.agencyDataCenterId + '</a>' +
							' - ' + value.address.city + ' ' + value.address.state + ', ' + value.address.zip + '</li>'
						);
					});
				});
			}
		}
	});

})(jQuery);
