#!/bin/env bash

SCRIPT_PWD="$(realpath "${BASH_SOURCE[0]}")"
SCRIPT_DIR="$(dirname "${SCRIPT_PWD}")"

cd "${SCRIPT_DIR}"/.. || exit 1

TMP_DIR=/tmp/relazione_preview_dirAWuaywdjb
mkdir -p "${TMP_DIR}"
cp Relazione.odt "${TMP_DIR}"
cd "${TMP_DIR}" || exit 1

libreoffice --convert-to pdf Relazione.odt 1>/dev/null
xdg-open Relazione.pdf &>/dev/null
