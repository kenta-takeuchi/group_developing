$(function(){
	$(".aq-text").hover(function(){
		$(this).addClass("aq-is-Hover");
		}
	),
	$(".aq-text").on('mouseleave', function(){
		$(this).removeClass("aq-is-Hover");
		}
	)
})
