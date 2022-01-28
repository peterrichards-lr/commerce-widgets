$('#thumbnail li').click(function ()
{
	$(this).addClass('active').siblings().removeClass('active');
	var slide = $('#slide li'),
			slideTop = 0,
			slideBlock = $('#slide ul'),
			thum = $('#thumbnail .thumbnail-list li'),
			thumTop = $('#thumbnail .thumbnail-list .active').position().top - $('#thumbnail .thumbnail-list').position().top + 'px';

	for (var i = 0; i < thum.length; i++)
	{
		if ($(thum[i]).hasClass('active'))
		{
			$($(slide)[i]).addClass('active').siblings().removeClass('active');
		}
	}

	for (var i = 0; i < slide.length; i++)
	{
		$($('#slide li .blur-img')[i]).attr('style', $($('#slide li .img')[i]).attr('style'));
		if ($($(slide)[i]).hasClass('active'))
		{
			slideTop += -(400 * i);
			$(slideBlock).css('transform', 'translateY(' + slideTop + 'px)');
		}
	}

	$('#thumbnail .marker').css('top', (thumTop));
});
$('#thumbnail li:first-child').addClass('active');