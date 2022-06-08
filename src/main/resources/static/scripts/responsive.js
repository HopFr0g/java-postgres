const responsiveMenu = document.querySelector(".nav-responsive__a-container");
const menuButton = document.querySelector(".nav-responsive__button");
const menuBlur = document.querySelector(".main__blur");

menuButton.addEventListener("click", () => {
    responsiveMenu.style.transform == "" ? displayMenu() : hideMenu();
});

menuBlur.addEventListener("click", () => {
    if (menuBlur.style.visibility == "visible")
        hideMenu();
});

const displayMenu = () => {
    responsiveMenu.style.transform = "TranslateY(100vh)";
    menuBlur.style.visibility = "visible";
    menuBlur.style.opacity = "1";
}

const hideMenu = () => {
    responsiveMenu.style.transform = "";
    menuBlur.style.visibility = "hidden";
    menuBlur.style.opacity = "0";
}