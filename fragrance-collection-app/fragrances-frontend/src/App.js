import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import FragranceList from "./components/FragranceList";
import AddPerfume from "./components/AddPerfume";

function App() {
  return (
    <Router>
      <div className="container">
        <h1>Fragrances Collection</h1>
        <nav>
          <ul className="nav nav-pills mt-3">
            <li className="nav-item">
              <Link className="nav-link" to="/">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/add-perfume">
                Add Perfume
              </Link>
            </li>
          </ul>
        </nav>
        <Routes>
          <Route path="/" element={<FragranceList />} />
          <Route path="/add-perfume" element={<AddPerfume />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
