function displayNextImage() {
    console.log('working')
    if(document.getElementById('img').src == 'https://www.mathsisfun.com/data/images/graph-gen.svg') {
        document.getElementById('img').src = 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Polynomial_of_degree_three.svg/1200px-Polynomial_of_degree_three.svg.png'
    } else {
        document.getElementById('img').src = 'https://www.mathsisfun.com/data/images/graph-gen.svg'
    }
}

movingblock = document.getElementsByClassName('graphs')
console.log(movingblock)
movingblock[0].addEventListener("animationiteration", displayNextImage);

