import React, { useState } from "react";
import axios from "axios";

const AddPerfume = () => {
    const [name, setName] = useState("");
    const [brand, setBrand] = useState("");
    const [price, setPrice] = useState("");
    const [type, setType] = useState("");
    const [description, setDescription] = useState("");


    const handleSubmit = async (e) => {
        e.preventDefault();
        const newPerfume = { name, brand, type, description, price: parseFloat(price) };

        try {
            await axios.post("http://localhost:8088/api/v1/fragrances", newPerfume);
            alert("Perfume added successfully!");
            setName("");
            setBrand("");
            setType("");
            setDescription("");
            setPrice("");
        } catch (error) {
            console.error("Error adding perfume:", error);
            alert("Failed to add perfume.");
        }
    };

    return (
        <div className="container mt-5">
            <h2>Add a New Perfume</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Perfume Name</label>
                    <input
                        type="text"
                        className="form-control"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Brand</label>
                    <input
                        type="text"
                        className="form-control"
                        value={brand}
                        onChange={(e) => setBrand(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Type</label>
                    <input
                        type="text"
                        className="form-control"
                        value={type}
                        onChange={(e) => setType(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Description</label>
                    <input
                        type="text"
                        className="form-control"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Price</label>
                    <input
                        type="number"
                        className="form-control"
                        value={price}
                        onChange={(e) => setPrice(e.target.value)}
                    />
                </div>
                <button type="submit" className="btn btn-primary mt-3">
                    Add Perfume
                </button>
            </form>
        </div>
    );
};

export default AddPerfume;
