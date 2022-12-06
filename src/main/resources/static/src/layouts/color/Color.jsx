import React, { Component } from 'react'
function Color() {
    return (
        <div className="theme-setting-wrapper">
            <div id="settings-trigger"><i className="ti-settings"></i></div>
            <div id="theme-settings" className="settings-panel">
                <i className="settings-close ti-close"></i>
                <p className="settings-heading">SIDEBAR SKINS</p>
                <div className="sidebar-bg-options selected" id="sidebar-light-theme">
                    <div className="img-ss rounded-circle bg-light border mr-3"></div>Light
                </div>
                <div className="sidebar-bg-options" id="sidebar-dark-theme">
                    <div className="img-ss rounded-circle bg-dark border mr-3"></div>Dark
                </div>
                <p className="settings-heading mt-2">HEADER SKINS</p>
                <div className="color-tiles mx-0 px-4">
                    <div className="tiles success"></div>
                    <div className="tiles warning"></div>
                    <div className="tiles danger"></div>
                    <div className="tiles info"></div>
                    <div className="tiles dark"></div>
                    <div className="tiles default"></div>
                </div>
            </div>
        </div>
    )
}
export default Color;