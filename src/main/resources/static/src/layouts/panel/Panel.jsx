import React, { Component } from 'react';


function Panel() {
    return (
        <div id="right-sidebar" className="settings-panel">
            <i className="settings-close ti-close"></i>
            <ul className="nav nav-tabs border-top" id="setting-panel" role="tablist">
                <li className="nav-item">
                    <a className="nav-link active" id="todo-tab" data-toggle="tab" href="#todo-section" role="tab"
                        aria-controls="todo-section" aria-expanded="true">TO DO LIST</a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" id="chats-tab" data-toggle="tab" href="#chats-section" role="tab"
                        aria-controls="chats-section">CHATS</a>
                </li>
            </ul>
            <div className="tab-content" id="setting-content">
                <div className="tab-pane fade show active scroll-wrapper" id="todo-section" role="tabpanel"
                    aria-labelledby="todo-section">
                    <div className="add-items d-flex px-3 mb-0">
                        <form className="form w-100">
                            <div className="form-group d-flex">
                                <input type="text" className="form-control todo-list-input" placeholder="Add To-do" />
                                <button type="submit" className="add btn btn-primary todo-list-add-btn"
                                    id="add-task">Add</button>
                            </div>
                        </form>
                    </div>
                    <div className="list-wrapper px-3">
                        <ul className="d-flex flex-column-reverse todo-list">
                            <li>
                                <div className="form-check">
                                    <label className="form-check-label">
                                        <input className="checkbox" type="checkbox" />
                                        Team review meeting at 3.00 PM
                                    </label>
                                </div>
                                <i className="remove ti-close"></i>
                            </li>
                        </ul>
                    </div>
                    <h4 className="px-3 text-muted mt-5 font-weight-light mb-0">Events</h4>
                    <div className="events pt-4 px-3">
                        <div className="wrapper d-flex mb-2">
                            <i className="ti-control-record text-primary mr-2"></i>
                            <span>Feb 11 2018</span>
                        </div>
                        <p className="mb-0 font-weight-thin text-gray">Creating component page build a js</p>
                        <p className="text-gray mb-0">The total number of sessions</p>
                    </div>
                </div>
                <div className="tab-pane fade" id="chats-section" role="tabpanel" aria-labelledby="chats-section">
                    <div className="d-flex align-items-center justify-content-between border-bottom">
                        <p className="settings-heading border-top-0 mb-3 pl-3 pt-0 border-bottom-0 pb-0">Friends</p>
                        <small
                            className="settings-heading border-top-0 mb-3 pt-0 border-bottom-0 pb-0 pr-3 font-weight-normal">See
                            All</small>
                    </div>
                    <ul className="chat-list">
                        <li className="list active">
                            <div className="profile"><img src="../static/images/faces/face1.jpg" alt="image" /><span
                                className="online"></span></div>
                            <div className="info">
                                <p>Thomas Douglas</p>
                                <p>Available</p>
                            </div>
                            <small className="text-muted my-auto">19 min</small>
                        </li>
                        <li className="list">
                            <div className="profile"><img src="../static/images/faces/face2.jpg" alt="image" /><span
                                className="offline"></span></div>
                            <div className="info">
                                <div className="wrapper d-flex">
                                    <p>Catherine</p>
                                </div>
                                <p>Away</p>
                            </div>
                            <div className="badge badge-success badge-pill my-auto mx-2">4</div>
                            <small className="text-muted my-auto">23 min</small>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    )
}
export default Panel;