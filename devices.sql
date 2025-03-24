CREATE TABLE devices (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    model NVARCHAR(255) NOT NULL,
    vendor NVARCHAR(255) NOT NULL,
    os_name NVARCHAR(100) NOT NULL,
    os_version NVARCHAR(50) NOT NULL,
    browser_name NVARCHAR(100) NOT NULL,
    primary_hardware_type NVARCHAR(100) NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);