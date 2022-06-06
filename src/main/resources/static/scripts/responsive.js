const responsiveMenu = document.querySelector(".nav-responsive__a-container");
const menuButton = document.querySelector(".nav-responsive__button");

menuButton.addEventListener("click", () => {
    responsiveMenu.style.transform == "" ? responsiveMenu.style.transform = "TranslateY(100vh)" : responsiveMenu.style.transform = "";
});