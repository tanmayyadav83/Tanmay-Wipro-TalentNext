function capitalizeWords(str) {
  return str
    .split(" ")
    .map((word) => word.charAt(0).toUpperCase() + word.slice(1))
    .join(" ");
}

// Example usage:
let input = "welcome to css world";
let result = capitalizeWords(input);
document.write(result); // Output: Welcome To Css World
