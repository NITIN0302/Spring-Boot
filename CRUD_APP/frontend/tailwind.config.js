/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      backgroundColor: {
        "custom-bg1": "#1f242d",
        "custom-bg2": "#323946",
        "custom-bg3": "#00eeff",
      },
    },
  },
  plugins: [],
};

// module.exports = {
//   plugins: [require('tailwind-scrollbar-hide')],
// };
