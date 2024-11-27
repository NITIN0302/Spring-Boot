import Navbar from "./layout/Navbar";
import { BrowserRouter,Routes,Route } from "react-router-dom";
import "./App.css";
import Home from "./pages/Home";
import AddUser from "./users/AddUser";
import EditUsers from "./users/EditUsers";
import DeleteUsers from "./users/DeleteUsers";

function App() {
  return (
    <BrowserRouter>
      <div className="h-screen w-full bg-custom-bg2">
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/Add" element={<AddUser />}></Route>
          <Route path="/Update" element={<EditUsers />}></Route>
          <Route path="/Delete" element={<DeleteUsers />}></Route>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
