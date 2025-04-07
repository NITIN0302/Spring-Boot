import React,{useState} from "react";
import { Link, Route, Routes } from "react-router-dom";

const Navbar = () => {
    const [colorId,setcolorId] = useState();

    return (
    <div className="bg-custom-bg1 flex flex-wrap justify-between text-white py-4">
      <div className="pl-4 w-[30%] text-xl font-bold">Navbar</div>
      <div className="w-[50%] flex flex-wrap justify-around">
        <div className={colorId === 1 ? "text-blue-500" : ""}>
          <Link to="/" onClick={()=>setcolorId(1)}>Home</Link>
        </div>
        <div className={colorId === 2 ? "text-blue-500" : ""}>
          <Link to="/Add" onClick={()=>setcolorId(2)}>Add</Link>
        </div>
        <div className={colorId === 3 ? "text-blue-500" : ""}>
          <Link to="/Update" onClick={()=>setcolorId(3)}>Update</Link>
        </div>
        <div className={colorId === 4 ? "text-blue-500" : ""}>
          <Link to="/Delete" onClick={()=>setcolorId(4)}>Delete</Link>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
