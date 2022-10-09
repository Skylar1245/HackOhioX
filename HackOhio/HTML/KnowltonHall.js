function displayNextImage() {
	if(document.getElementById('img').src =='https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotAnnual.png') {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotCategories.png';
	} else if(document.getElementById('img').src =='https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotCategories.png') {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotPerPerson.png';
	} else {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotAnnual.png';
	}
}

movingblock = document.getElementsByClassName('graphs');
movingblock[0].addEventListener("animationiteration", displayNextImage);
