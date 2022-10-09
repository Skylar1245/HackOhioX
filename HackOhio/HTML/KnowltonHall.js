//changes the image on the scroll block
function displayNextImage() {
	//check which image is currently displayed
	if(document.getElementById('img').src =='https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotAnnual.png') {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotCategories.png';
	} else if(document.getElementById('img').src =='https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotCategories.png') {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotPerPerson.png';
	} else {
		document.getElementById('img').src = 'https://raw.githubusercontent.com/Skylar1245/HackOhioX/master/HackOhio/graphs/KnowltonPlotAnnual.png';
	}
}

//gets an array of all the elements within the class of graphs

movingblock = document.getElementsByClassName('graphs');

//waits until the animation has finished an iteration to switch the image
movingblock[0].addEventListener("animationiteration", displayNextImage);
