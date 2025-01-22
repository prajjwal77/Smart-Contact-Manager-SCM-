/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./src/**/*.{html,js,ts,jsx,tsx}",
    "./src/main/resources/templates/**/*.html",
    "./src/main/resources/static/**/*.html",
  ],
  theme: {
    extend: {},
  },
  plugins: [],
  darkMode:"selector",
}

